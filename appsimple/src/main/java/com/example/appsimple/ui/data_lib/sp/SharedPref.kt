package com.example.appsimple.ui.data_lib.sp

import android.content.Context
import com.example.appsimple.base.App
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import kotlin.jvm.Throws
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SharedPref<T>(
    private val name: String,
    private val defValue: T,
    private val pref: String = "default"
) : ReadWriteProperty<Any?, T> {

    private val prefs by lazy {
        App.application.getSharedPreferences(pref, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T =
        findPreference(findProperName(property))

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) =
        putPreference(findProperName(property), value)

    /**
     * 删除全部数据
     */
    fun clear() {
        prefs.edit().clear().apply()
    }

    /**
     * 根据key删除存储数据
     */
    fun remove(key: String) {
        prefs.edit().remove(key).apply()
    }

    private fun findProperName(property: KProperty<*>) = if (name.isEmpty()) property.name else name

    private fun findPreference(key: String): T =  with(prefs) {
        val res: Any = when (defValue) {
            is Long -> getLong(name, defValue)
            is String -> getString(name, defValue)
            is Int -> getInt(name, defValue)
            is Boolean -> getBoolean(name, defValue)
            is Float -> getFloat(name, defValue)
            else -> throw IllegalArgumentException("Unsupported type")
        }!!
        res as T
    }

    private fun putPreference(key: String, value: T) {
        val edit = prefs.edit().apply {
            when (value) {
                is Int -> putInt(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                is Boolean -> putBoolean(key, value)
                is String -> putString(key, value)
                else -> throw IllegalArgumentException("Unsupported type")
            }
        }
        edit.apply()
    }



}