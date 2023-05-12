package com.example.agriapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.agriapp.*

class MainActivityBuyer : AppCompatActivity() {



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_buyer)

//        val Ava = findViewById<ImageButton>(R.id.available)
//        Ava.setOnClickListener {
//            val Intent = Intent(this, Available_crops::class.java)
//            startActivity(Intent)
//        }

        val Add = findViewById<ImageButton>(R.id.addrequest)
        Add.setOnClickListener {
            val intent = Intent(this, AddRequestActivities::class.java)
            startActivity(intent)
        }

        val Edit = findViewById<ImageButton>(R.id.edit)
        Edit.setOnClickListener {
            val intent = Intent(this, FetchingCropActivity::class.java)
            startActivity(intent)
        }

//        val pro = findViewById<ImageButton>(R.id.imageButton2)
//        pro.setOnClickListener {
//            val Intent = Intent(this, profile::class.java)
//            startActivity(Intent)
//        }

        }

}
