package com.wukangjie.baselib.base.fragment

import android.os.Bundle
import androidx.lifecycle.Observer
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import com.wukangjie.baselib.base.viewmodel.ErrorState
import com.wukangjie.baselib.base.viewmodel.LoadState
import com.wukangjie.baselib.base.viewmodel.SuccessState

/**
 * Fragment懒加载
 */
abstract class BaseVmFragment : BaseFragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModelAction()

    }


    private fun initViewModelAction() {
        getViewModel().mStateLiveData.observe(viewLifecycleOwner, Observer {
            when(it) {
                is ErrorState ->{
                    // TODO: 2020/7/29
                }
            }
        } )
        this.getViewModel().let { baseViewModel ->
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

    abstract fun getViewModel(): BaseViewModel

    open fun showLoading() {

    }

    open fun dismissLoading() {

    }

    open fun handleError() {

    }
}