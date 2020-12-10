package com.example.appsimple.ui.main


import com.example.appsimple.R
import com.example.appsimple.ui.glide_plaette.GlidePaletteFragment
import com.wukangjie.baselib.base.activity.BaseAppCompatActivity

class MainActivity : BaseAppCompatActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, MainFragment.newInstance())
            .commitNow()
    }
}
