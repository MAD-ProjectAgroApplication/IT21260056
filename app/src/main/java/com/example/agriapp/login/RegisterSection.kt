package com.example.agriapp.login;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.agriapp.R

class RegisterSection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rgister_section)

        //farmer
        val FarmerBtn = findViewById<Button>(R.id.farmerbtn)
        FarmerBtn.setOnClickListener {
            val Intent = Intent(this, Register::class.java)
            startActivity(Intent)
        }
        //buyer
        val BuyerBtn = findViewById<Button>(R.id.buyerbtn)
        BuyerBtn.setOnClickListener {
            val Intent = Intent(this, Register::class.java)
            startActivity(Intent)
        }

        //fertilizer
        val FertilizerBtn = findViewById<Button>(R.id.fertilizer_sellerbtn)
        FertilizerBtn.setOnClickListener {
            val Intent = Intent(this, Register::class.java)
            startActivity(Intent)
        }

        //seed distributor
        val seedDistributorrBtn = findViewById<Button>(R.id.distributorbtn)
        seedDistributorrBtn.setOnClickListener {
            val Intent = Intent(this, Register::class.java)
            startActivity(Intent)
        }
    }
}