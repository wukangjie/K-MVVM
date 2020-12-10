package com.example.appsimple.base

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import com.example.appsimple.dao.DaoMaster
import com.example.appsimple.dao.DaoMaster.DevOpenHelper
import com.example.appsimple.dao.DaoSession
import com.example.appsimple.tasks.InitBuGlyTask
import com.example.appsimple.tasks.InitCrashTask
import com.example.appsimple.tasks.InitKoInTask
import com.example.appsimple.tasks.InitSmartRefreshLayoutTask
import com.example.appsimple.ui.data_lib.object_box.ObjectBox
import com.fmt.launch.starter.TaskDispatcher
import com.tencent.mmkv.MMKV
import com.wukangjie.baselib.base.BaseApplication


class App : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        application = this
        TaskDispatcher.init(this)
        TaskDispatcher.createInstance()
            .addTask(InitBuGlyTask())
            .addTask(InitKoInTask())
            .addTask(InitCrashTask())
            .addTask(InitSmartRefreshLayoutTask())
            .start()

        val rootDir: String = MMKV.initialize(this)

        ObjectBox.init(this)

        initGreenDao()

//        LoadSir.beginBuilder()
//            .addCallback(ErrorCallback())
//            .addCallback(EmptyCallback())
//            .addCallback(LoadingCallback())
//            .addCallback(TimeoutCallback())
//            .addCallback(CustomCallback())
//            .setDefaultCallback(LoadingCallback::class.java)
//            .commit()
    }

    private fun initGreenDao() {
        //创建数据库mydb.db
        val helper = DevOpenHelper(application, "mydb.db")
        //获取可写数据库
        val database: SQLiteDatabase = helper.writableDatabase
        //获取数据库对象
        val daoMaster = DaoMaster(database)
        //获取Dao对象管理者
        mDaoSession = daoMaster.newSession()
    }

    fun getmDaoSession(): DaoSession? {
        return mDaoSession
    }

    companion object {
        @JvmStatic
        lateinit var application: Application
            private set

        @JvmStatic
        lateinit var mDaoSession: DaoSession
        private set
    }
}