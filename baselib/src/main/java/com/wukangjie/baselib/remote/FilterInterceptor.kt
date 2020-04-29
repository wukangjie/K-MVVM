package com.wukangjie.baselib.remote

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * 过滤拦截器
 */
class FilterInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val httpBuilder = originalRequest.url.newBuilder()
        httpBuilder.addEncodedQueryParameter(HttpConfig.KEY, HttpConfig.KEY_MAP)
        val requestBuilder = originalRequest.newBuilder()
            .url(httpBuilder.build())
        return chain.proceed(requestBuilder.build())
    }

}