package com.wukangjie.baselib.remote


sealed class BaseException(errorMessage: String, val code: Int = HttpConfig.CODE_UNKNOWN) : RuntimeException(errorMessage)

class ServerResultException(message: String, code: Int = HttpConfig.CODE_UNKNOWN) : BaseException(message, code)