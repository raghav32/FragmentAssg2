package com.example.fragmentassg2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.BundleCompat
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val manager=supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment()

        back.setOnClickListener {
            manager.popBackStack()
        }
    }

       private fun addFragment(){
        val fragment=FragmentLogin()
           val transaction=manager.beginTransaction()
        transaction.add(R.id.root_layout, fragment)
        transaction.commit()
    }

    fun showBackButton(enable:Boolean){
        back?.visibility= if(enable) View.VISIBLE else View.GONE
    }
}
