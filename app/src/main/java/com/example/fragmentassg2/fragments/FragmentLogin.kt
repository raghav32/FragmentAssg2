package com.example.fragmentassg2.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.fragmentassg2.MainActivity
import com.example.fragmentassg2.R
import com.example.fragmentassg2.util.Constant
import com.example.fragmentassg2.viewModel.LoginViewModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.login_fragment.view.*

class FragmentLogin : Fragment(), View.OnClickListener {


    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.login_fragment,container,false)
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

        editPhoneIme.addTextChangedListener(object:TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    if( editPhone.editText?.text.toString()==Constant.USER_PHONE_NUMBER && editPhone.editText?.text.toString().length==10 )
                        btnLogin.isEnabled=true
            }
            override fun afterTextChanged(s: Editable?) {

            }
        })

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

        val checkPhoneNumber:Boolean=viewModel.validatePhoneNumber(editPhone.editText?.text.toString())

        if(checkPhoneNumber){

            val phNum=editPhone.editText?.text.toString()
            val action=FragmentLoginDirections.actionFragmentLoginToFragmentPassword(phNum)
            findNavController().navigate(action)

        }
        else {
            Toast.makeText(requireActivity(), getString(R.string.lbl_wrong), Toast.LENGTH_SHORT).show()
        }
    }
}