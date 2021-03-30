package com.example.fragmentassg2.data

import androidx.lifecycle.LiveData

//repository--repo class abstracts access to multiple data sources

class UserRepository(private val userDao:UserDao) {

    val readAllData:LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user:User){
        userDao.addUser(user)
    }
}