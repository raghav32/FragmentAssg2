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
import com.example.fragmentassg2.MainActivity
import com.example.fragmentassg2.R
import com.example.fragmentassg2.util.Constant
import com.example.fragmentassg2.viewModel.OTPViewModel
import com.example.fragmentassg2.viewModel.PasswordViewModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.password_fragment.*

class FragmentPassword : Fragment(), View.OnClickListener {

    private lateinit var viewModel: PasswordViewModel

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
           val mobile= arguments?.getString(Constant.USER_KEY_PHONE)

           val checkPass:Boolean=viewModel.validatePassword(Constant.USER_PASS)
            val passwordEqual:Boolean=viewModel.passEqual(Constant.USER_PASS)

           if(passwordEqual && checkPass){
            val fragmentOtp= FragmentOTP()
            val fragmentManager=activity!!.supportFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()

            val bundle=Bundle()
            bundle.putString(Constant.USER_KEY_PHONE,mobile)
            fragmentOtp.arguments=bundle

            fragmentTransaction.setCustomAnimations(
                R.anim.enter_right_to_left,
                R.anim.exit_right_to_left,
                R.anim.enter_left_to_right,
                R.anim.exit_left_to_right
            )
            fragmentTransaction.replace(R.id.root_layout,fragmentOtp)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        else
        Toast.makeText(context,getString(R.string.lbl_wrong_pass),Toast.LENGTH_SHORT).show()

        }
}