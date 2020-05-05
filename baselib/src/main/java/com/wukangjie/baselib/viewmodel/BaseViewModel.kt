package com.wukangjie.baselib.viewmodel

import androidx.lifecycle.*
import com.wukangjie.baselib.presenter.IBaseViewModelEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


open class BaseViewModel : ViewModel(), IBaseViewModelEvent {

    val baseActionEvent = MutableLiveData<BaseViewModelEvent>()

    val mStateLiveData = MutableLiveData<StateActionEvent>()//通用事件模型驱动(如：显示对话框、取消对话框、错误提示)

    fun launch(block: suspend CoroutineScope.() -> Unit) {//使用协程封装统一的网络请求处理
        viewModelScope.launch {
            //ViewModel自带的viewModelScope.launch,会在页面销毁的时候自动取消请求,有效封装内存泄露
            try {
                mStateLiveData.value = LoadState
                block()
                mStateLiveData.value = SuccessState
            } catch (e: Exception) {
                mStateLiveData.value = ErrorState(e.message)
            }
        }
    }

    fun <T> emit(block: suspend LiveDataScope<T>.() -> T): LiveData<T> = liveData {
        try {
            mStateLiveData.value = LoadState
            emit(block())
            mStateLiveData.value = SuccessState
        } catch (e: Exception) {
            mStateLiveData.value = ErrorState(e.message)
        }
    }

    override fun showLoading(msg: String) {
        val event =
            BaseViewModelEvent(BaseViewModelEvent.SHOW_LOADING_DIALOG)
        event.message = msg
        baseActionEvent.value = event
    }

    override fun dismissLoading() {
        val event =
            BaseViewModelEvent(BaseViewModelEvent.DISMISS_LOADING_DIALOG)
        baseActionEvent.value = event
    }

    override fun showToast(msg: String) {
        val event =
            BaseViewModelEvent(BaseViewModelEvent.SHOW_TOAST)
        event.message = msg
        baseActionEvent.value = event
    }

    override fun finishView() {
        val event =
            BaseViewModelEvent(BaseViewModelEvent.FINISH)
        baseActionEvent.value = event
    }

    override fun pop() {
        val event =
            BaseViewModelEvent(BaseViewModelEvent.POP)
        baseActionEvent.value = event
    }

}