package com.example.agriapp.login;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.agriapp.R
import com.example.agriapp.activities.MainActivityBuyer
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class login : AppCompatActivity() {
    private lateinit var LoginPGBtnFarmer : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        LoginPGBtnFarmer = findViewById(R.id.loginBtnLoginPg)

        LoginPGBtnFarmer.setOnClickListener {
            val intent = Intent(this, MainActivityBuyer::class.java)
            startActivity(intent)
        }


    }
}