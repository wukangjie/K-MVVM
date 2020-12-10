package com.example.appsimple.ui.glide_plaette

import com.example.appsimple.R
import com.example.appsimple.base.BaseActivity

class GlidePaletteActivity : BaseActivity() {

    override fun getLayoutId(): Int {
      return R.layout.activity_glide_palette
    }

    override fun initView() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, GlidePaletteFragment.newInstance())
            .commitNow()
    }
}