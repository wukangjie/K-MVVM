package com.wukangjie.baselib.base

import android.app.Application
import android.content.ContextWrapper
import com.wukangjie.baselib.tasks.InitBuGlyTask
import com.wukangjie.baselib.tasks.InitKoInTask
import com.fmt.github.tasks.InitLiveEventBusTask
import com.fmt.github.tasks.InitSmartRefreshLayoutTask
import com.fmt.launch.starter.TaskDispatcher


lateinit var mApplication : Application

class BaseApplication : Application() {



    companion object {
        lateinit var context: BaseApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        mApplication = this

        TaskDispatcher.init(this)
        TaskDispatcher.createInstance()
            .addTask(InitBuGlyTask())
            .addTask(InitKoInTask())
            .addTask(InitLiveEventBusTask())
            .addTask(InitSmartRefreshLayoutTask())
            .start()
    }

    object AppContext : ContextWrapper(mApplication)//ContextWrapper对Context上下文进行包装(装饰者模式)
}