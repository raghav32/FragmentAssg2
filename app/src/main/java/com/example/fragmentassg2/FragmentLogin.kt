package com.example.fragmentassg2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.login_fragment.view.*

class FragmentLogin : Fragment(), View.OnClickListener {



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


        btnLogin.setOnClickListener(){
            val number ="9953755955"

            if(editPhone.editText?.text.toString()==number){





                val fragment=FragmentPassword()
                val fragmentManager=activity!!.supportFragmentManager
                val fragmentTransaction=fragmentManager.beginTransaction()

                val bundle=Bundle()
                bundle.putString("key",number)
                fragment.arguments=bundle

                fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                fragmentTransaction.replace(R.id.root_layout,fragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
            else
                Toast.makeText(context,"wrong",Toast.LENGTH_SHORT).show()

        }
    }

    override fun onClick(v: View?) {
        when(v){
            btnHindi->Toast.makeText(context,"Language Hindi",Toast.LENGTH_SHORT).show()
            btnSkip->Toast.makeText(context,"Skip",Toast.LENGTH_SHORT).show()
        }

    }


}



