package com.example.appsimple.ui.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appsimple.R

class ViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_model_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ViewModelFragment.newInstance())
                .commitNow()
        }
    }

}
