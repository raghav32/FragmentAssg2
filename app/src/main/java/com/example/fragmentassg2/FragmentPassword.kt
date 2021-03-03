package com.example.fragmentassg2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.password_fragment.*

class FragmentPassword : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.password_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvFor.setOnClickListener(){
            Toast.makeText(context,"Forgot Password",Toast.LENGTH_SHORT).show()
        }

        tvEnter.setOnClickListener(){
            Toast.makeText(context,"Enter Password",Toast.LENGTH_SHORT).show()
        }

        tvGreat.setOnClickListener(){
            Toast.makeText(context,"Great to see you again",Toast.LENGTH_SHORT).show()
        }

        btnProceed.setOnClickListener(){
            val pass:String="1234"
            if(editPassword.text.toString()==pass){
                val fragment= FragmentOTP()
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