package com.wukangjie.baselib.util

import android.app.Application

class AppConfig private constructor() {

    companion object {
        val instance by lazy { AppConfig() }
    }

    fun init(application: Application) {
        listOf(
            CacheUtil.instance
        ).map {
//            it.init(application)
        }
    }
}