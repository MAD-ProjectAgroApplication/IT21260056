package com.example.agriapp.login;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.agriapp.R
import com.example.agriapp.login.MainActivity
import com.example.agriapp.models.BuyerModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etAddress: EditText
    private lateinit var etTel: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassward: EditText
    private lateinit var etRePassward: EditText
    private lateinit var btnRegister: Button

    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)



        etName = findViewById(R.id.enterName)
        etAddress = findViewById(R.id.enterAddress)
        etTel = findViewById(R.id.enterTel)
        etEmail = findViewById(R.id.enterEmail)
        etPassward = findViewById(R.id.enterPassword)
        etRePassward = findViewById(R.id.enterRePassword)
        btnRegister = findViewById(R.id.register3btn)

        dbRef = FirebaseDatabase.getInstance().getReference("Buyer_Details")

        btnRegister.setOnClickListener {
            Registration()

            //farmer
            val RegisterBtn = findViewById<Button>(R.id.register3btn)
            RegisterBtn.setOnClickListener {
                val Intent = Intent(this, MainActivity::class.java)
                startActivity(Intent)
            }
        }


    }
    private fun Registration(){

        //getting values
        val name = etName.text.toString().trim()
        val address = etAddress.text.toString().trim()
        val tel = etTel.text.toString().trim()
        val eMail = etEmail.text.toString().trim()
        val passward = etPassward.text.toString().trim()
        val repassward = etRePassward.text.toString().trim()
        val mobilePattern = "^[+]?[0-9]{10,13}\$"

        if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "Please enter Employee Name",Toast.LENGTH_LONG).show()
            return@Registration
        }
        else if (TextUtils.isEmpty(address)){
            Toast.makeText(this, "Please enter Employee Address",Toast.LENGTH_LONG).show()
            return@Registration

        }
//        (!sellerMobile.matches(mobilePattern.toRegex()))
//        else if (TextUtils.isEmpty(tel) ){
        else if (!tel.matches(mobilePattern.toRegex())){
            Toast.makeText(this, "Please enter  Telephone number",Toast.LENGTH_LONG).show()
            return@Registration
        }

//        if(!Patterns.EMAIL_ADDRESS.matcher(sellerEmail).matches()){
      else if (TextUtils.isEmpty(eMail) || !eMail.contains("@gmail")){
//        else if (!Patterns.EMAIL_ADDRESS.matcher(eMail).matches()){
            Toast.makeText(this, "Please enter Valid Email",Toast.LENGTH_LONG).show()
            return@Registration

        }
        else if (TextUtils.isEmpty(passward)){
            Toast.makeText(this,  "Please enter passward",Toast.LENGTH_LONG).show()
            return@Registration

        }
        else if (TextUtils.isEmpty(repassward) || !passward.equals(repassward)){
            Toast.makeText(this,  "Password does not match",Toast.LENGTH_LONG).show()
            return@Registration
        }

        val empId = dbRef.push().key!!


        val employee = BuyerModel(empId, name, address, tel,eMail,passward,repassward)

        dbRef.child(empId).setValue(employee)
            .addOnCompleteListener{
                Toast.makeText(this,"Data Insert Successfully", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{ err ->
                Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()
            }



    }


}