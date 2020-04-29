package com.wukangjie.baselib.base.fragment

import android.content.Context

/**
 * tab页中，带有画面跳转功能的画面的容器fragment
 */

open class BaseMainFragment : BaseFragment() {

    protected var _mBackToFirstListener: OnBackToFirstListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnBackToFirstListener) {
            _mBackToFirstListener = context
        } else {
            throw RuntimeException("$context must implement OnBackToFirstListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        _mBackToFirstListener = null
    }

    /**
     * 处理回退事件
     *
     * @return
     */
    override fun onBackPressedSupport(): Boolean {
        if (childFragmentManager.backStackEntryCount > 1) {
            popChild()
        } else {
            if (shouldFinishActivity()) {   // 如果是 第一个Fragment 则退出app
                _mActivity!!.finish()
            } else {                                    // 如果不是,则回到第一个Fragment
                _mBackToFirstListener!!.onBackToFirstFragment()
            }
        }
        return true
    }

    protected fun shouldFinishActivity(): Boolean {
        return false
    }

    interface OnBackToFirstListener {
        fun onBackToFirstFragment()
    }
}
