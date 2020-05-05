package com.example.appsimple.ui.viewmodel

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appsimple.R
import com.wukangjie.baselib.base.fragment.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class ViewModelFragment : BaseFragment() {

    companion object {
        fun newInstance() = ViewModelFragment()
    }

    private val viewModel: ViewModelViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.view_model_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(ViewModelViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
