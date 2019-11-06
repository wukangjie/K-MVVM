package com.wukangjie.k_mvvm

import android.os.Bundle
import com.wukangjie.baselib.base.BaseAppCompatActivity

class MainActivity : BaseAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        topFragment
    }
}
