package com.wukangjie.baselib.base.activity

import androidx.lifecycle.Observer
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import com.wukangjie.baselib.base.viewmodel.ErrorState
import com.wukangjie.baselib.base.viewmodel.LoadState
import com.wukangjie.baselib.base.viewmodel.SuccessState

abstract class BaseVMActivity : BaseAppCompatActivity(){

    override fun setContentLayout() {
        super.setContentLayout()
        initViewModelAction()
    }


    protected fun initViewModelAction() {
        getViewModel()?.let { baseViewModel ->
            baseViewModel.mStateLiveData.observe(this, Observer { stateActionState ->
                when (stateActionState) {
                    LoadState -> showLoading()
                    SuccessState -> dismissLoading()
                    is ErrorState -> {
                        dismissLoading()
                        stateActionState.exception.errorMsg.apply {
                    //                            errorToast(this)
                            handleError()
                        }
                    }
                }
            })
        }
    }



     open fun getViewModel(): BaseViewModel? {
         return BaseViewModel()
     }



    open fun showLoading() {

    }

    open fun dismissLoading() {

    }

    open fun handleError() {

    }
}