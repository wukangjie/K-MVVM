package com.fmt.github.di

import android.util.Log
import com.wukangjie.baselib.data.http.interceptor.AuthorizationInterceptor
import com.wukangjie.baselib.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val DB_NAME = "open_github_db"
private const val BASE_URL = "https://api.github.com/"
private const val TIME_OUT = 30L
private const val TAG = "fmt"

val viewModelModule = module {
//    viewModel { HomeViewModel(get()) }
//    viewModel { ReceivedEventViewModel(get()) }
//    viewModel { ReposViewModel(get()) }
//    viewModel { UserViewModel(get()) }
}

val reposModule = module {
    //factory 每次注入时都重新创建一个新的对象
//    factory { ReposRepository(get()) }
//    factory { UserRepository(get(), get()) }
}

val remoteModule = module {
    //single 单例对象
    single {
        val httpLoggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.e(TAG, message)
            }
        })
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpLoggingInterceptor
    }

    single {
        val builder = OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor())
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(get<HttpLoggingInterceptor>())
        }
        builder.build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .baseUrl(BASE_URL)
            .build()
    }

//    single<ReposApi> { get<Retrofit>().create(ReposApi::class.java) }

//    single<UserApi> { get<Retrofit>().create(UserApi::class.java) }
}

val localModule = module {
    single {
//        Room.databaseBuilder(AppContext, AppDataBase::class.java, DB_NAME).build()
    }
//    single { get<AppDataBase>().getUserDao() }
}

val appModule = listOf(viewModelModule, reposModule, remoteModule, localModule)