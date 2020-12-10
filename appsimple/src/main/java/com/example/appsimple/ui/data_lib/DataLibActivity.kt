package com.example.appsimple.ui.data_lib

import com.example.appsimple.R
import com.example.appsimple.base.BaseActivity

class DataLibActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_data_lib
    }

    override fun initView() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DataLibFragment.newInstance())
            .commitNow()
    }
}