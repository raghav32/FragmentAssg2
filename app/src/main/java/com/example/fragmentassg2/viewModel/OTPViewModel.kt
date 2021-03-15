package com.example.fragmentassg2.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel

class OTPViewModel:ViewModel() {

    override fun onCleared() {
        super.onCleared()
        Log.i("OTPViewModel", "OTPViewModel destroyed!")
    }

    fun validateOTP(otp: String): Boolean {
        return otp.isNotEmpty() && otp.isNotBlank()
    }
}