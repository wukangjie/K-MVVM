package com.example.appsimple.ui.splash

import android.os.Bundle
import com.example.appsimple.R
import com.example.appsimple.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        this.window.decorView.setBackgroundResource(R.mipmap.ic_splash)
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
       return R.layout.activity_splash
    }

    override fun initView() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, SplashFragment.newInstance())
            .commitNow()
    }
}