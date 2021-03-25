package com.example.fragmentassg2.bottomsheetFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentassg2.R
import com.example.fragmentassg2.util.Constant
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.login_bottomsheet.*

class BottomSheetLogin:BottomSheetDialogFragment() {

    val bottomSheetPassword=BottomSheetPassword()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_bottomsheet,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val phone:String=Constant.USER_PHONE_NUMBER

        bsBtnLogin.setOnClickListener {
            if(bsEditPhone.editText?.text.toString()==phone){
                val fragment=BottomSheetPassword()
                val fragmentManager= requireActivity().supportFragmentManager
                val fragmentTransaction=fragmentManager.beginTransaction()
                fragmentTransaction.add(fragment,"BottomSheetDialog")
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }
    }
}