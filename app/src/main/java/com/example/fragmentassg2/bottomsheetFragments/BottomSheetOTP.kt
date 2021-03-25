package com.example.fragmentassg2.bottomsheetFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentassg2.HomeActivity
import com.example.fragmentassg2.R
import com.example.fragmentassg2.WelcomeActivity
import com.example.fragmentassg2.util.Constant
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.otp_bottomsheet.*

class BottomSheetOTP:BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.otp_bottomsheet,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val otp=Constant.USER_OTP

        bsBtnOtp.setOnClickListener {
            if(bsEditOtp.editText?.text.toString()==otp){
                val intent= Intent(context, WelcomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}