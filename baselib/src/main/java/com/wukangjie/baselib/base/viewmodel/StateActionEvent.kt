package com.wukangjie.baselib.base.viewmodel

import com.wukangjie.baselib.remote.AppException

//定义网络请求状态(密封类扩展性更好)
sealed class StateActionEvent

object LoadState : StateActionEvent()

object SuccessState : StateActionEvent()

class ErrorState(val exception: AppException) : StateActionEvent()