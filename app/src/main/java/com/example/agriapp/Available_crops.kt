package com.example.agriapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Available_crops : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_available_crops)

        val Crop11 = findViewById<ImageButton>(R.id.imageView31)
        Crop11.setOnClickListener {
            val Intent = Intent(this,Crop1::class.java)
            startActivity(Intent)
        }

        val Main = findViewById<ImageButton>(R.id.home)
        Main.setOnClickListener {
            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)
        }
    }
}