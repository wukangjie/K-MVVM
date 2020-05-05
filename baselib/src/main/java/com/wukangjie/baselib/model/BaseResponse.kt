package com.wukangjie.baselib.model

import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @SerializedName("status") var code: Int = 0,
    @SerializedName("info") var message: String? = null,
    @SerializedName("districts", alternate = ["forecasts"]) var data: T
)

class OptionT<T>(val value: T)