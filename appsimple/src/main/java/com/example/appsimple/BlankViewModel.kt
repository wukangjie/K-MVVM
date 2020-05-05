package com.example.appsimple

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel() {
    fun refreshData() {
        liveData.postValue(Math.random().toString())
    }

    var string : String = "asdddd"

    var liveData : MutableLiveData<String> = MutableLiveData("123")


}
