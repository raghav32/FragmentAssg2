package com.example.fragmentassg2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//database--contains the database holder and serves as the main access point for the underlying connection to your app

@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class UserDatabase:RoomDatabase() {

    abstract fun userDao():UserDao

    companion object{
        @Volatile
       var INSTANCE:UserDatabase?=null

        fun getDatabase(context: Context):UserDatabase{
            //val tempInstance= INSTANCE
            if(INSTANCE!=null){
                return INSTANCE as UserDatabase
            }
            synchronized(this){
                 INSTANCE= Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()

                return INSTANCE as UserDatabase
            }
        }
    }
}