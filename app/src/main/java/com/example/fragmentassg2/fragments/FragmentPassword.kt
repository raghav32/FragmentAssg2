package com.example.fragmentassg2.fragments

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
import com.example.fragmentassg2.MainActivity
import com.example.fragmentassg2.R
import com.example.fragmentassg2.util.Constant
import com.example.fragmentassg2.viewModel.OTPViewModel
import com.example.fragmentassg2.viewModel.PasswordViewModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.password_fragment.*

class FragmentPassword : Fragment(), View.OnClickListener {

    private lateinit var viewModel: PasswordViewModel
    private val args:FragmentPasswordArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.password_fragment,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("PasswordFragment", "Called ViewModelProvider.get")
        // Get the viewModel
        viewModel = ViewModelProvider(this).get(PasswordViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvFor?.setOnClickListener(this)
        btnProceed?.setOnClickListener(this)

        (requireActivity() as MainActivity).showBackButton(true)


        view.findViewById<TextInputEditText>(R.id.editPassIme).setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    proceed()
                    true
                }
                else -> false
            }
        }
    }
    override fun onClick(v: View?) {
        when(v){
            tvFor->Toast.makeText(context,getString(R.string.forgotpass),Toast.LENGTH_SHORT).show()
            btnProceed->{
               proceed()
            }
        }
    }
       private fun proceed(){

           val mobile= args.otpHelp
           val checkPass:Boolean=viewModel.validatePassword(editPassword.editText?.text.toString())
           if( checkPass){
              val action1= FragmentPasswordDirections.actionFragmentPasswordToFragmentOTP(mobile)
               findNavController().navigate(action1)
        }

        else
        Toast.makeText(context,getString(R.string.lbl_wrong_pass),Toast.LENGTH_SHORT).show()

        }
}