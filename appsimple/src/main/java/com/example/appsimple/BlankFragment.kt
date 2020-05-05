package com.example.appsimple

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.fmt.github.ext.yes
import com.wukangjie.baselib.base.fragment.BaseFragment
import kotlinx.android.synthetic.main.blank_fragment.*


class BlankFragment : BaseFragment() {

    companion object {
        fun newInstance() = BlankFragment()
    }

    private lateinit var viewModel: BlankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.blank_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlankViewModel::class.java)

        viewModel.liveData.observe(this, Observer {
            blankTv.text = it
        })

        blankTv.setOnClickListener(View.OnClickListener {
            viewModel.refreshData()
        })

    }

}
