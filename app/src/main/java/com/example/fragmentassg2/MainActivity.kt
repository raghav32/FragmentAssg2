package com.example.fragmentassg2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.example.fragmentassg2.fragments.FragmentLogin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  var navController:NavController?=null
    private val manager=supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        back.setOnClickListener {
            navController?.navigateUp()
            //manager.popBackStack()
        }

         navController = (fragment as NavHostFragment).navController
        val navGraph:NavGraph? = navController?.navInflater?.inflate(R.navigation.my_nav)
        if (navGraph != null) {
            navController?.graph = navGraph
        }
    }

    fun showBackButton(enable:Boolean){
        back?.visibility= if(enable) View.VISIBLE else View.GONE
    }
}
