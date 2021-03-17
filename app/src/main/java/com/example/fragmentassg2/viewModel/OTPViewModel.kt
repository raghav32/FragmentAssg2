package com.example.fragmentassg2.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.fragmentassg2.util.Constant

class OTPViewModel:ViewModel() {

    override fun onCleared() {
        super.onCleared()
        Log.i("OTPViewModel", "OTPViewModel destroyed!")
    }

    fun validateOTP(otp: String): Boolean {
        return otp.isNotEmpty() && otp.isNotBlank()
    }

    fun otpEqual(user_otp:String):Boolean{
        if(user_otp== Constant.USER_OTP)
            return true
        else
            return false
    }
}