package com.wukangjie.baselib.base.activity

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseDbActivity<DB : ViewDataBinding> : BaseAppCompatActivity() {

    lateinit var mDataBind: DB

    /**
     * 如果要用 #ViewDataBinding, 该方法中就不要super.setContentLayout
     */
    override fun setContentLayout() {
        mDataBind = DataBindingUtil.setContentView(this, getLayoutId())
        mDataBind.lifecycleOwner = this
        initView()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        mDataBind.unbind()
    }

}