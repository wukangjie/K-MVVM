package com.example.appsimple.ui.data_lib.data_store

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appsimple.R
import com.example.appsimple.base.BaseFragment
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DataStoreFragment : BaseFragment() {

    companion object {
        fun newInstance() = DataStoreFragment()
    }

    private val  mViewModel: DataStoreViewModel by viewModel()

    override fun getLayoutId(): Int {
       return R.layout.fragment_data_store
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