package com.example.fragmentassg2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import com.example.fragmentassg2.fragments.FragmentLogin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val manager=supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        back.setOnClickListener {
            manager.popBackStack()
        }

        val navController = (fragment as NavHostFragment).navController
        val navGraph = navController.navInflater.inflate(R.navigation.my_nav)
        navController.graph = navGraph
    }

    fun showBackButton(enable:Boolean){
        back?.visibility= if(enable) View.VISIBLE else View.GONE
    }
}
