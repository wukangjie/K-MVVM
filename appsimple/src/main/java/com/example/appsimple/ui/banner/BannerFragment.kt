package com.example.appsimple.ui.banner

import com.example.appsimple.R
import com.example.appsimple.base.BaseFragment
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_banner.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BannerFragment : BaseFragment() {

    companion object {
        fun newInstance() = BannerFragment()
    }

    private  val mViewModel: BannerViewModel by viewModel()

    override fun getLayoutId(): Int {
       return R.layout.fragment_banner
    }

    override fun initView() {

        youthBanner

    }

    override fun initData() {

    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun createObserver() {

    }

}