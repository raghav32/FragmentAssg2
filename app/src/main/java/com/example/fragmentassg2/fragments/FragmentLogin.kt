package com.example.fragmentassg2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragmentassg2.MainActivity
import com.example.fragmentassg2.R
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.login_fragment.view.*

class FragmentLogin : Fragment(), View.OnClickListener {

    private val fragment= FragmentPassword()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment,container,false)
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
        val number ="9953755955"

        if(editPhone.editText?.text.toString()==number){
            val fragmentManager=requireActivity().supportFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()

            val bundle=Bundle()
            bundle.putString("PhoneKey",number)
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
        else
            Toast.makeText(context,"wrong",Toast.LENGTH_SHORT).show()
    }
}