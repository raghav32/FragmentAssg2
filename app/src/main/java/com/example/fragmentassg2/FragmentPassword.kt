package com.example.fragmentassg2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.password_fragment.*

class FragmentPassword : Fragment(), View.OnClickListener {

    private val pass="1234"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.password_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvFor?.setOnClickListener(this)
        tvEnter?.setOnClickListener(this)
        btnProceed?.setOnClickListener(this)
        btnBack?.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        val mobile= arguments?.getString("PhoneKey")
        when(v){

            tvFor->Toast.makeText(context,getString(R.string.forgotpass),Toast.LENGTH_SHORT).show()
            tvEnter->Toast.makeText(context,getString(R.string.pass),Toast.LENGTH_SHORT).show()


            btnProceed->{

                if(editPassword.editText?.text.toString()==pass){
                    val fragmentOtp= FragmentOTP()
                    val fragmentManager=activity!!.supportFragmentManager
                    val fragmentTransaction=fragmentManager.beginTransaction()

                    val bundle=Bundle()
                    bundle.putString("PhoneKey",mobile)
                    fragmentOtp.arguments=bundle

                    fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                    fragmentTransaction.replace(R.id.root_layout,fragmentOtp)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
                else
                    Toast.makeText(context,"wrong",Toast.LENGTH_SHORT).show()
            }
            btnBack->{
                replaceFragment()
            }
        }
    }

    private fun replaceFragment() {
        val fragmentReplaceLogin=FragmentLogin()
        val fragmentManager=activity!!.supportFragmentManager
        val transaction=fragmentManager.beginTransaction()
       transaction.setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right,R.anim.enter_right_to_left,R.anim.exit_right_to_left)
        transaction.replace(R.id.root_layout,fragmentReplaceLogin)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}