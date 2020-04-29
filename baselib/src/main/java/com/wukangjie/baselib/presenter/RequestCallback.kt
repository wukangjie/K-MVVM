package com.wukangjie.baselib.presenter

import com.wukangjie.baselib.remote.BaseException


interface RequestCallback<T> {

    fun onSuccess(data: T)

}

interface RequestMultiplyCallback<T> : RequestCallback<T> {

    fun onFail(e: BaseException)

}