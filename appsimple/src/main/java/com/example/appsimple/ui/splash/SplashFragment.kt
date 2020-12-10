package com.example.appsimple.ui.splash

import com.example.appsimple.R
import com.example.appsimple.base.BaseFragment
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment() {

    companion object {
        fun newInstance() = SplashFragment()
    }

    private  val mViewModel: SplashViewModel by viewModel()



    override fun getLayoutId(): Int {
        return R.layout.fragment_splash
    }

    override fun initView() {

    }

    override fun initData() {

    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun createObserver() {

    }

}