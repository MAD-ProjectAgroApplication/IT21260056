package com.example.agriapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.agriapp.R
import com.example.agriapp.models.CropModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddRequestActivities : AppCompatActivity() {
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
        val name = etname.text.toString().trim()
        val crop = etCropName.text.toString().trim()
        val location = etlocation.text.toString().trim()
        val amount = etamount.text.toString().trim()

        if (name.isEmpty()){
            etname.error = "Please enter Your Name"
            return@saveEmployeeData
        }
        else if(crop.isEmpty()){
            etCropName.error = "Please enter Crop type"
            return@saveEmployeeData
        }
        if (location.isEmpty()){
            etlocation.error = "Please enter Your location"
            return@saveEmployeeData
        }
        if (amount.isEmpty()){
            etamount.error = "Please enter Amount of crops"
            return@saveEmployeeData
        }

        val Orderid = dbRef.push().key!!

        val cropOrder = CropModel(Orderid,name,crop,location, amount)

        dbRef.child(Orderid).setValue(cropOrder)
            .addOnCompleteListener{
                Toast.makeText(this,"Data Insert Successfully", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{ err ->
                Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()
            }


    }
}