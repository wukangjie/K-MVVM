package com.example.appsimple.ui.main

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsimple.R
import com.example.appsimple.base.BaseFragment
import com.example.appsimple.ui.data_lib.DataLibActivity
import com.example.appsimple.ui.glide.GlideActivity
import com.example.appsimple.ui.glide_plaette.GlidePaletteActivity
import com.example.appsimple.ui.splash.SplashActivity
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val mViewModel: MainViewModel by viewModel()


    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initView() {


        val mainAdapter = MainAdapter()
        val list = mutableListOf("Glide加载图片", "Glide调色板", "启动页", "数据存储")

        mainAdapter.setNewInstance(list)
        mainAdapter.setOnItemClickListener { _, _, position ->
            val intent: Intent = when (position) {
                0 -> {
                    Intent(_mActivity, GlideActivity::class.java)
                }
                1-> {
                    Intent(_mActivity, GlidePaletteActivity::class.java)
                }
                2-> {
                    Intent(_mActivity, SplashActivity::class.java)
                }
                3->{
                    Intent(_mActivity, DataLibActivity::class.java)
                }
                else -> {
                    Intent(_mActivity, GlideActivity::class.java)
                }
            }

            startActivity(intent)

        }
        recyclerView.adapter = mainAdapter
        recyclerView.layoutManager = LinearLayoutManager(_mActivity)
    }



    override fun initData() {

    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun createObserver() {

    }

}