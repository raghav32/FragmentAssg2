package com.example.fragmentassg2.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.fragmentassg2.util.Constant

class PasswordViewModel:ViewModel() {

    override fun onCleared() {
        super.onCleared()
        Log.i("PasswordViewModel", "PasswordViewModel destroyed!")
    }

    fun validatePassword(pass:String):Boolean{
        return pass.isNotEmpty() && pass.isNotBlank() && return pass== Constant.USER_PASS
    }
}