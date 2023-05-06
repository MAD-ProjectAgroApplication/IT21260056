package com.example.agriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddRequest : AppCompatActivity() {
    private lateinit var etname: EditText
    private lateinit var etCropName: EditText
    private lateinit var etlocation: EditText
    private lateinit var etamount: EditText
    private lateinit var btnSubmitData: Button


    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_request)

        etname = findViewById(R.id.etname)
        etCropName = findViewById(R.id.etCropName)
        etlocation = findViewById(R.id.etlocation)
        etamount = findViewById(R.id.etamount)
        btnSubmitData = findViewById(R.id.btnSubmitData)

        dbRef = FirebaseDatabase.getInstance().getReference("cropOrders")

        btnSubmitData.setOnClickListener {
            saveEmployeeData()
        }

    }


    private fun saveEmployeeData(){

        //getting values
        val name = etname.text.toString()
        val crop = etCropName.text.toString()
        val location = etlocation.text.toString()
        val amount = etamount.text.toString()

        if (name.isEmpty()){
            etname.error = "Please enter Your Name"
        }
        else if(crop.isEmpty()){
            etCropName.error = "Please enter Crop type"
        }
        if (location.isEmpty()){
            etlocation.error = "Please enter Your location"
        }
        if (amount.isEmpty()){
            etamount.error = "Please enter Amount of crops"
        }

        val empId = dbRef.push().key!!

        val cropOrder = OrderCrops(name,crop,location,amount)

        dbRef.child(empId).setValue(cropOrder)
            .addOnCompleteListener{
                Toast.makeText(this,"Data Insert Successfully", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{ err ->
                Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()
            }


    }
}