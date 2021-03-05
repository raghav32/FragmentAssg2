package com.example.fragmentassg2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.BundleCompat
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private val manager=supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment()

    }

    private fun addFragment(){
        val fragment=FragmentLogin()
        val transaction=manager.beginTransaction()
        transaction.add(R.id.root_layout, fragment)
       // transaction.addToBackStack(null)
        transaction.commit()
    }


}
