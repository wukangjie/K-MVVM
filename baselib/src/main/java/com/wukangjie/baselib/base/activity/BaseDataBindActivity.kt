package com.wukangjie.baselib.base.activity

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlinx.coroutines.cancel

abstract class BaseDataBindActivity<DB : ViewDataBinding> : BaseAppCompatActivity() {

    lateinit var mDataBind: DB

    override fun setContentLayout() {
        mDataBind = DataBindingUtil.setContentView(this, getLayoutId())
        initView()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        mDataBind.unbind()
    }

}