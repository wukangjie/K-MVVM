package com.example.appsimple.ui.glide

import com.example.appsimple.R
import com.example.appsimple.base.BaseActivity

class GlideActivity : BaseActivity() {

    override fun getLayoutId(): Int {
      return R.layout.activity_glide
    }

    override fun initView() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, GlideFragment.newInstance())
            .commitNow()
    }
}