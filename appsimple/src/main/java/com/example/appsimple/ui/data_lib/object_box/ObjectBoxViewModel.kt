package com.example.appsimple.ui.data_lib.object_box

import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import io.objectbox.Box
import io.objectbox.android.ObjectBoxLiveData

class ObjectBoxViewModel : BaseViewModel() {

    private lateinit var noteLiveData: ObjectBoxLiveData<User>

    fun getUserLiveData(notesBox: Box<User>): ObjectBoxLiveData<User> {
        if (!this::noteLiveData.isInitialized) {
            // query all notes, sorted a-z by their text (https://docs.objectbox.io/queries)
            noteLiveData = ObjectBoxLiveData(notesBox.query().order(User_.name).build())
        }
        return noteLiveData
    }
}