package com.example.fragmentassg2.bottomsheetFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentassg2.R
import com.example.fragmentassg2.util.Constant
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.password_bottomsheet.*

class BottomSheetPassword:BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.password_bottomsheet,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pass:String=Constant.USER_PASS

        bsBtnPass.setOnClickListener {
            if(bsEditPass.editText?.text.toString()==pass){
                val fragment=BottomSheetOTP()
                val fragmentManager= requireActivity().supportFragmentManager
                val fragmentTransaction=fragmentManager.beginTransaction()
                fragmentTransaction.add(fragment,"BottomSheetDialog")
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }

    }
}