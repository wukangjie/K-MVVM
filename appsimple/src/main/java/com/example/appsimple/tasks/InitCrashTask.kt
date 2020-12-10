package com.example.appsimple.tasks

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.fmt.launch.starter.task.Task
import com.wukangjie.baselib.cockroach.Cockroach
import com.wukangjie.baselib.cockroach.ExceptionHandler


open class InitCrashTask : Task() {
    override fun run() {
        val sysExcepHandler = Thread.getDefaultUncaughtExceptionHandler()

        Cockroach.install(mContext, object : ExceptionHandler() {
            override fun onUncaughtExceptionHappened(thread: Thread, throwable: Throwable?) {
                Log.e("AndroidRuntime", "--->onUncaughtExceptionHappened:$thread<---", throwable)

                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(mContext, "捕获到导致崩溃的异常", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onBandageExceptionHappened(throwable: Throwable) {
                throwable.printStackTrace() //打印警告级别log，该throwable可能是最开始的bug导致的，无需关心

                Toast.makeText(mContext, "Cockroach Worked", Toast.LENGTH_SHORT).show()

            }

            override fun onEnterSafeMode() {
            }

            override fun onMayBeBlackScreen(e: Throwable?) {
                val thread = Looper.getMainLooper().thread
                Log.e("AndroidRuntime", "--->onUncaughtExceptionHappened:$thread<---", e)
                //黑屏时建议直接杀死app
                sysExcepHandler.uncaughtException(thread, RuntimeException("black screen"))
            }
        })
    }
}