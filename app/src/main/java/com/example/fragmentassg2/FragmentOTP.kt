package com.example.fragmentassg2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.otp_fragment.*

class FragmentOTP : Fragment() {

    private val otp="567890"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.otp_fragment,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvVerify.text=getString(R.string.lbl_enter_otp_sent_to,arguments?.getString("PhoneKey"))

        view.findViewById<TextInputEditText>(R.id.editOTPIme).setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    val intent=Intent(context,HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }


        btnSubmit.setOnClickListener(){

            if(editOTP.editText?.text.toString()==otp){
                val intent=Intent(context,HomeActivity::class.java)
                startActivity(intent)
            }
            else
                Toast.makeText(context,"wrong", Toast.LENGTH_SHORT).show()
        }
    }
}