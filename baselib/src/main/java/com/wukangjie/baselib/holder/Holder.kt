package com.wukangjie.baselib.holder

import android.content.Context
import android.widget.Toast
import com.wukangjie.baselib.base.BaseApplication

/**
 * 持有Application引用的toast
 * @author wkj
 */

class ContextHolder {
    companion object {
        val context: Context by lazy { BaseApplication.context }
    }

    class ToastHolder {
        companion object {
            fun showToast(context: Context = ContextHolder.context, msg: String) {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            }
        }
    }
}