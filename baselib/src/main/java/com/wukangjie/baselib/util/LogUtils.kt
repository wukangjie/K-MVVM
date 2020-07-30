package com.wukangjie.baselib.util

import android.util.Log
import com.wukangjie.baselib.BuildConfig
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.nio.charset.Charset

object LogUtils {

    /**
     * Log output should be via this class
     * whether it is in log output mode.
     * Always change to false when releasing apk.
     */
    private const val TAG = "TAG_MVVM"

    fun v(msg: String) {
        outputLog(msg)
    }

    fun e(msg: String, e: Exception) {
        outputLog(Log.ERROR, msg, e)
    }

    fun w(msg: String) {
        outputLog(Log.WARN, msg)
    }

    /**
     * 输出生命周期
     * @param instance
     * @param <T>
    </T> */
    fun <T : Any> trace(instance: T) {
        v(instance.javaClass.simpleName + ": " + Thread.currentThread().stackTrace[3].methodName)
    }

    /**
     * 记录输出
     * 始终使用Log.DEBUG输出
     *
     * @param msg
     */
    fun outputLog(msg: String) {
        outputLog(Log.DEBUG, msg, null)
    }

    /**
     * 记录输出
     *
     * @param type log种类
     * @param msg  log信息
     */
    fun outputLog(type: Int, msg: String) {
        outputLog(type, msg, null)
    }

    /**
     * 记录输出
     *
     * @param type log种类
     * @param msg  log信息
     * @param e    异常信息
     */
    fun outputLog(type: Int, msg: String, e: Exception?) {
        if (!BuildConfig.LOG_MODE) {
            return
        }

        when (type) {
            Log.ASSERT -> {
            }
            Log.ERROR -> Log.e(TAG, msg, e)
            Log.WARN -> Log.w(TAG, msg)
            Log.DEBUG -> Log.d(TAG, msg)
            Log.INFO -> Log.i(TAG, msg)
            Log.VERBOSE -> Log.v(TAG, msg)
            else -> {
            }
        }
    }

    /**
     * 将日志输出到指定路径的文件。
     *
     * @param directoryPath
     * @param msg
     */
    fun outputLog(directoryPath: String, msg: String) {
        val directory = File(directoryPath)
        if (!directory.isDirectory) {
            directory.mkdirs()
        }

        val f = File("$directoryPath/log.txt")
        try {
            val fileOutputStream = FileOutputStream(f, true)
            val outputStreamWriter = OutputStreamWriter(fileOutputStream, Charset.defaultCharset())
            val writer = PrintWriter(outputStreamWriter)
            writer.append(msg).append("\r\n")
            writer.flush()
            writer.close()
        } catch (e: Exception) {
            outputLog(Log.ERROR, "outputLog : Exception", e)
        }

    }
}