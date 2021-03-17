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
import com.example.fragmentassg2.viewModel.LoginViewModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.login_fragment.view.*

class FragmentLogin : Fragment(), View.OnClickListener {

    private val fragment= FragmentPassword()

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("LoginFragment", "Called ViewModelProvider.get")
        // Get the viewModel
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnHindi?.setOnClickListener(this)
        btnSkip?.setOnClickListener(this)
        btnLogin?.setOnClickListener(this)

        (requireActivity() as MainActivity).showBackButton(false)

        view.findViewById<TextInputEditText>(R.id.editPhoneIme).setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    login()
                    true
                }
                else -> false
            }
        }
    }

    override fun onClick(v: View?) {
        when(v){

            btnHindi->Toast.makeText(context,getString(R.string.lbl_btn_hindi),Toast.LENGTH_SHORT).show()
            btnSkip->Toast.makeText(context,getString(R.string.lbl_btn_skip),Toast.LENGTH_SHORT).show()
            btnLogin->{
               login()
            }
        }
    }
    private fun login(){

        val checkPhoneNumber:Boolean=viewModel.validatePhoneNumber(Constant.USER_PHONE_NUMBER)
        val phoneNumberEqual:Boolean=viewModel.phoneEqual(Constant.USER_PHONE_NUMBER)
        val phoneNumberLength:Boolean=viewModel.phoneLength(Constant.USER_PHONE_NUMBER)

        if(phoneNumberEqual && checkPhoneNumber && phoneNumberLength){

            val fragmentManager=requireActivity().supportFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()

            val bundle= Bundle()
            bundle.putString(Constant.USER_KEY_PHONE,Constant.USER_PHONE_NUMBER)
            fragment.arguments=bundle

            fragmentTransaction.setCustomAnimations(
                R.anim.enter_right_to_left,
                R.anim.exit_right_to_left,
                R.anim.enter_left_to_right,
                R.anim.exit_left_to_right
            )
            fragmentTransaction.replace(R.id.root_layout,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        else {
            Toast.makeText(requireActivity(), getString(R.string.lbl_wrong), Toast.LENGTH_SHORT).show()
        }
    }
}