package com.example.agriapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class myOrder : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_order)

        val update = findViewById<Button>(R.id.button9)
        update.setOnClickListener {
            val Intent = Intent(this,updateDetails::class.java)
            startActivity(Intent)
        }
    }
}