package com.wukangjie.baselib.base.activity

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import com.noober.background.BackgroundLibrary
import com.wukangjie.baselib.util.LogUtils
import me.yokeyword.fragmentation.SupportActivity
import me.yokeyword.fragmentation.SupportActivityDelegate

/**
 * Do someting common. All activities should extend from this class.
 *
 * @author wkjie
 */
abstract class BaseAppCompatActivity : SupportActivity() {

    private var mProgressDialog: Dialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        BackgroundLibrary.inject(this)
        super.onCreate(savedInstanceState)
        // 隐藏导航
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContentLayout()

        LogUtils.trace(this)
    }

    open fun setContentLayout() {
        setContentView(getLayoutId())
        initView()
        initData()
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

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

    @SuppressLint("MissingSuperCall")
    override fun onSaveInstanceState(outState: Bundle) {
        //        super.onSaveInstanceState(outState);
    }

    override fun onStop() {
        super.onStop()
        LogUtils.trace(this)
    }

    override fun finish() {
        super.finish()
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.dismiss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.trace(this)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            try {
                val intent = Intent(Intent.ACTION_MAIN)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.addCategory(Intent.CATEGORY_HOME)
                startActivity(intent)
            } catch (ignored: NullPointerException) {

            }

            return true
        } else if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


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
