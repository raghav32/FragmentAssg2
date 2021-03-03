package com.example.fragmentassg2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_fragment.*

class FragmentLogin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvGood.setOnClickListener(){
            Toast.makeText(context,"Good To See You Again",Toast.LENGTH_SHORT).show()
        }

        tvDownload.setOnClickListener(){
            Toast.makeText(context,"Download here",Toast.LENGTH_SHORT).show()
        }

        tvForgot.setOnClickListener(){
            Toast.makeText(context,"Forgot PassWord",Toast.LENGTH_SHORT).show()
        }

        tvSSO.setOnClickListener(){
            Toast.makeText(context,"Login with SSO",Toast.LENGTH_SHORT).show()
        }

        tvSign.setOnClickListener(){
            Toast.makeText(context,"Sign up",Toast.LENGTH_SHORT).show()
        }

        btnGoogle.setOnClickListener(){
            Toast.makeText(context,"Google login",Toast.LENGTH_SHORT).show()
        }

        btnLogin.setOnClickListener(){
            val number : String="9953755955"
            if(editPhone.text.toString()==number){
                val fragment=FragmentPassword()
                val fragmentManager=activity!!.supportFragmentManager
                val fragmentTransaction=fragmentManager.beginTransaction()
                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                fragmentTransaction.replace(R.id.root_layout,fragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
            else
                Toast.makeText(context,"wrong",Toast.LENGTH_SHORT).show()

        }
    }

}