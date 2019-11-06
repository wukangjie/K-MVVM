package com.wukangjie.baselib.base

import android.app.Application

class BaseApplication : Application() {

    companion object {
        lateinit var context: BaseApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}