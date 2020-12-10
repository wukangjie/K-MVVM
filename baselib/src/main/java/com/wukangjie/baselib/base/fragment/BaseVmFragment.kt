package com.wukangjie.baselib.base.fragment

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import com.wukangjie.baselib.base.viewmodel.ErrorState
import com.wukangjie.baselib.base.viewmodel.LoadState
import com.wukangjie.baselib.base.viewmodel.SuccessState
import com.wukangjie.baselib.remote.AppException

/**
 * Fragment懒加载
 */
abstract class BaseVmFragment : BaseSupportFragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModelAction()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createObserver()
    }


    private fun initViewModelAction() {
        getViewModel().let { baseViewModel ->
            baseViewModel.mStateLiveData.observe(this, Observer { stateActionState ->
                when (stateActionState) {
                    LoadState -> showLoading()
                    SuccessState -> dismissLoading()
                    is ErrorState -> {
                        dismissLoading()
                        stateActionState.exception.apply {
                            //                            errorToast(this)
                            handleError(this)
                        }
                    }
                }
            })
        }
    }

    abstract fun getViewModel(): BaseViewModel

    abstract fun createObserver()

    open fun showLoading() {

    }

    open fun dismissLoading() {

    }

    open fun handleError(appException: AppException) {

    }
}