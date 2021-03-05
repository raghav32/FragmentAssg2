package com.example.fragmentassg2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.otp_fragment.*

class FragmentOTP : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.otp_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSubmit.setOnClickListener(){
            val otp="567890"
            if(editOTP.editText?.text.toString()==otp){
                val intent=Intent(context,HomeActivity::class.java)
                startActivity(intent)
            }
            else
                Toast.makeText(context,"wrong", Toast.LENGTH_SHORT).show()
        }
    }
}