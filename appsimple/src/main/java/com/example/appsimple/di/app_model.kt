package com.example.appsimple.di

import org.koin.dsl.module


private const val DB_NAME = "open_github_db"



val reposModule = module {
    //factory 每次注入时都重新创建一个新的对象
//    factory { ReposRepository(get()) }
//    factory { UserRepository(get(), get()) }
}



val localModule = module {
    single {
//        Room.databaseBuilder(AppContext, AppDataBase::class.java, DB_NAME).build()
    }
//    single { get<AppDataBase>().getUserDao() }
}

val appModule = listOf(viewModelModule, reposModule, remoteModule, localModule)