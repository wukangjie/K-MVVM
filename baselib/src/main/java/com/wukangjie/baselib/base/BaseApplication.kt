package com.wukangjie.baselib.base

import android.app.Application
import android.content.ContextWrapper
import androidx.multidex.MultiDexApplication


lateinit var mApplication : Application

open class BaseApplication : MultiDexApplication() {



    companion object {
        lateinit var context: BaseApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        mApplication = this
    }

    object AppContext : ContextWrapper(mApplication)//ContextWrapper对Context上下文进行包装(装饰者模式)
}