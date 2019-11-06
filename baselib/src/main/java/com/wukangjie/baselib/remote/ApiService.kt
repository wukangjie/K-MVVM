package com.wukangjie.baselib.remote

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    //加载天气
    @GET("adat/sk/{cityId}.html")
    fun loadDataByRetrofit(@Path("cityId") cityId: String): Call<String>

    //加载天气
    @GET("adat/sk/{cityId}.html")
    fun loadDataByRetrofitRxJava(@Path("cityId") cityId: String): Observable<String>
}
