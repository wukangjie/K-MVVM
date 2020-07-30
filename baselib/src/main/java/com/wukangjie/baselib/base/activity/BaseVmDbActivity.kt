package com.wukangjie.baselib.base.activity

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.wukangjie.baselib.base.viewmodel.BaseViewModel

/**
 * 封装带有协程基类(DataBinding + ViewModel),使用代理类完成
 *
 */
abstract class BaseVmDbActivity< DB : ViewDataBinding> : BaseVMActivity() {

    lateinit var mDataBind: DB

    /**
     * 如果要用 #ViewDataBinding, 该方法中就不要super.setContentLayout
     */
    override fun setContentLayout() {
        mDataBind = DataBindingUtil.setContentView(this, getLayoutId())
        mDataBind.lifecycleOwner = this
        initView()
        initData()
        initViewModelAction()
    }

    override fun onDestroy() {
        super.onDestroy()
        mDataBind.unbind()
    }

}