package com.example.fragmentassg2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    val manager=supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment()

    }

    fun addFragment(){
        val fragment=FragmentLogin()
        val transaction=manager.beginTransaction()
        transaction.add(R.id.root_layout, fragment)
       // transaction.addToBackStack(null)
        transaction.commit()
    }

    fun replaceFragment(){
        val fragment=FragmentLogin()
        val transaction=manager.beginTransaction()
        transaction.replace(R.id.root_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

}
}