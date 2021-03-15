package com.example.fragmentassg2.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel

class PasswordViewModel:ViewModel() {

    override fun onCleared() {
        super.onCleared()
        Log.i("PasswordViewModel", "PasswordViewModel destroyed!")
    }
}