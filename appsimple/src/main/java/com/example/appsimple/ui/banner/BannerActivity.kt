package com.example.appsimple.ui.banner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appsimple.R
import com.example.appsimple.base.BaseActivity

class BannerActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_banner
    }

    override fun initView() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, BannerFragment.newInstance())
            .commitNow()
    }
}