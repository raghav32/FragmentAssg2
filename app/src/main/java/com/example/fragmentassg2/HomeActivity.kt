package com.example.fragmentassg2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentassg2.bottomsheetFragments.BottomSheetLogin
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val bottomSheetLogin=BottomSheetLogin()

        btnBottomSheet.setOnClickListener {
            bottomSheetLogin.show(supportFragmentManager,"BottomSheetDialog")
        }

        btnFullScreen.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}