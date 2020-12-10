package com.wukangjie.baselib.model

import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @SerializedName("code") var code: Int = 0,
    @SerializedName("msg") var message: String? = null,
    @SerializedName("data") var data: T
)