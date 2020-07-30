package com.example.appsimple.config

import com.wukangjie.baselib.data.storage.Preference

object Settings {

    object Account {
        var token by Preference(Constant.USER_TOKEN, "")
        var userName by Preference(Constant.USER_NAME, "")
        var password by Preference(Constant.USER_PASSWORD, "")
    }
}