package com.wukangjie.baselib.base.viewmodel

import androidx.lifecycle.*
import com.wukangjie.baselib.model.BaseResponse
import com.wukangjie.baselib.remote.AppException
import com.wukangjie.baselib.remote.ExceptionHandle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


open class BaseViewModel : ViewModel() {

    val mStateLiveData = MutableLiveData<StateActionEvent>()//通用事件模型驱动(如：显示对话框、取消对话框、错误提示)

    fun launch(block: suspend CoroutineScope.() -> Unit) {//使用协程封装统一的网络请求处理
        viewModelScope.launch {
            //ViewModel自带的viewModelScope.launch,会在页面销毁的时候自动取消请求,有效封装内存泄露
            try {
                mStateLiveData.value = LoadState
                block()
                mStateLiveData.value = SuccessState
            } catch (e: Exception) {
                mStateLiveData.value = ErrorState(e as AppException)
            }
        }
    }

    fun <T> emit(block: suspend LiveDataScope<T>.() -> T): LiveData<T> = liveData {
        try {
            mStateLiveData.value = LoadState
            emit(block())
            mStateLiveData.value = SuccessState
        } catch (e: Exception) {
            mStateLiveData.value = ErrorState(e as AppException)
        }
    }

    fun <T> request(
            block: suspend () -> BaseResponse<T>,
            success: (T) -> Unit,
            error: (AppException) -> Unit = {},
            isShowDialog: Boolean = false,
            loadingMessage: String = "请求网络中..."
    ): Job {
        //如果需要弹窗 通知Activity/fragment弹窗
        return viewModelScope.launch {
            runCatching {
                if (isShowDialog) mStateLiveData.postValue(LoadState)
                //请求体
                block()
            }.onSuccess {
                //网络请求成功 关闭弹窗
                mStateLiveData.postValue(SuccessState)
                runCatching {
                    //校验请求结果码是否正确，不正确会抛出异常走下面的onFailure
                    if (it.code == 0) {
                        success(it.data)
                    }
                }
            }.onFailure {
                //网络请求异常 关闭弹窗
                mStateLiveData.postValue(ErrorState(ExceptionHandle.handleException(it)))
                //失败回调
                error(ExceptionHandle.handleException(it))
            }
        }
    }

}