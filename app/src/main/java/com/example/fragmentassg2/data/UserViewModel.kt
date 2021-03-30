package com.example.fragmentassg2.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//uvm--acts as a communication center between the repo and the ui

class UserViewModel(application: Application):AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
    private val repository:UserRepository
    private val userDao=UserDatabase.getDatabase(application.applicationContext).userDao()

    init {
        repository= UserRepository(userDao)
        readAllData=repository.readAllData
    }

    fun addUser(user:User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}