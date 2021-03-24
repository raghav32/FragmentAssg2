package com.example.fragmentassg2.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//Representing table in the database
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName:String,
    val secondName:String,
    val phone:Int
)