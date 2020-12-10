package com.wukangjie.baselib.base.activity

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import com.noober.background.BackgroundLibrary
import com.wukangjie.baselib.util.LogUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import me.yokeyword.fragmentation.SupportActivity
import okhttp3.Dispatcher

/**
 * Do someting common. All activities should extend from this class.
 *
 * @author wkjie
 */
abstract class BaseAppCompatActivity : SupportActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        BackgroundLibrary.inject(this)
        super.onCreate(savedInstanceState)
        // 隐藏导航
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        //设置方向为竖屏显示
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        //设置内部View
        setContentLayout()

        LogUtils.trace(this)
    }

    open fun setContentLayout() {
        setContentView(getLayoutId())
        initView()
        initData()

        runBlocking{}
    }

    abstract fun getLayoutId(): Int

    /**
     * View的初始化操作
     */
    abstract fun initView()

    /**
     * 数据的初始化操作
     */
    open fun initData() {

    }

    override fun onStart() {
        super.onStart()
        LogUtils.trace(this)
    }

    override fun onResume() {
        super.onResume()
        LogUtils.trace(this)
    }

    override fun onPause() {
        super.onPause()
        LogUtils.trace(this)
    }

    override fun onStop() {
        super.onStop()
        LogUtils.trace(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.trace(this)
    }

    /**
     * 强制显示键盘
     */
    protected fun showInput(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED)
    }

    /**
     * 强制显示键盘
     */
    fun showInput() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    /**
     * 隐藏输入键盘
     *
     * @param v
     */
    fun hideInput(v: View?) {
        if (v == null) {
            return
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)
    }

}
