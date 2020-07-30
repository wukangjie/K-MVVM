package com.example.appsimple


import com.wukangjie.baselib.base.activity.BaseAppCompatActivity

class MainActivity : BaseAppCompatActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        supportFragmentManager.beginTransaction()
//            .add(R.id.container, BlankFragment.newInstance())
            .commitNow()
    }
}
