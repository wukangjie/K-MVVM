package com.example.appsimple.ui.data_lib.sp

object SpSetting {
    var name by SharedPref( "name", "")
    var uid by SharedPref( "uid", -1L)
}