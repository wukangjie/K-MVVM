package com.wukangjie.baselib.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

//@Database(entities = [User::class], version = 1)
abstract class AppDataBase : RoomDatabase(){

//    abstract fun getUserDao(): UserDao
}