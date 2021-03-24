package com.example.fragmentassg2.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmentassg2.HomeActivity
import com.example.fragmentassg2.MainActivity
import com.example.fragmentassg2.R
import com.example.fragmentassg2.util.Constant
import com.example.fragmentassg2.viewModel.LoginViewModel
import com.example.fragmentassg2.viewModel.OTPViewModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.otp_fragment.*

class FragmentOTP : Fragment() {

    private lateinit var viewModel: OTPViewModel
    private val args:FragmentOTPArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.otp_fragment,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("OTPFragment", "Called ViewModelProvider.get")
        // Get the viewModel
        viewModel = ViewModelProvider(this).get(OTPViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        numberOtp.text=args.otpNum

        (requireActivity() as MainActivity).showBackButton(true)

        view.findViewById<TextInputEditText>(R.id.editOTPIme).setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    submit()
                    true
                }
                else -> false
            }
        }

        btnSubmit.setOnClickListener(){
            val checkOTP:Boolean=viewModel.validateOTP(editOTP.editText?.text.toString())

            if(checkOTP){
                submit()
                requireActivity().finish()
            }
            else
                Toast.makeText(context,getString(R.string.lbl_wrong_otp), Toast.LENGTH_SHORT).show()
        }
    }

    private fun submit(){
        findNavController().navigate(R.id.action_fragmentOTP_to_listFragment)
    }
}