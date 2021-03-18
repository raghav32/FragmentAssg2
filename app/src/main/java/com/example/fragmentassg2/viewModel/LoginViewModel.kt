package com.example.fragmentassg2.viewModel

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.fragmentassg2.R
import com.example.fragmentassg2.fragments.FragmentPassword
import com.example.fragmentassg2.util.Constant
import kotlinx.android.synthetic.main.login_fragment.*

class LoginViewModel: ViewModel() {


    override fun onCleared() {
        super.onCleared()
        Log.i("LoginViewModel", "LoginViewModel destroyed!")
    }

    fun validatePhoneNumber(phoneNumber: String): Boolean {
        return phoneNumber.isNotEmpty() &&  phoneNumber==Constant.USER_PHONE_NUMBER
    }

  //  fun phoneEqual(numberEqual:String):Boolean{
    //    return numberEqual==Constant.USER_PHONE_NUMBER
// }
}