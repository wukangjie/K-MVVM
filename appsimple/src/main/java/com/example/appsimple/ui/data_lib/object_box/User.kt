package com.example.appsimple.ui.data_lib.object_box

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class User (@Id var id: Long = 0,
                 var name: String? = null)
