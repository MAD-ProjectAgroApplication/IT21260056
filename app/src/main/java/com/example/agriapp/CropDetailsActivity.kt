package com.example.agriapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.agriapp.activities.FetchingCropActivity
import com.example.agriapp.models.CropModel
import com.google.firebase.database.FirebaseDatabase

class CropDetailsActivity : AppCompatActivity(){

    private lateinit var tvOrderId: TextView
    private lateinit var tvName: TextView
    private lateinit var tvCropName: TextView
    private lateinit var tvLocation: TextView
    private lateinit var tvAmount: TextView
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crop_details)

        initView()
        setValuesToViews()

        btnUpdate.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("Orderid").toString(),
                intent.getStringExtra("name").toString()
            )
        }

        btnDelete.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("Orderid").toString()
            )
        }

    }

    private fun initView() {
        tvOrderId = findViewById(R.id.tvOrderId)
//        tvName = findViewById(R.id.tvName)
        tvCropName = findViewById(R.id.tvCropName)
        tvLocation = findViewById(R.id.tvLocation)
        tvAmount = findViewById(R.id.tvAmount)

        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
    }

    private fun setValuesToViews() {
        tvOrderId.text = intent.getStringExtra("Orderid")
        tvName.text = intent.getStringExtra("name")
        tvCropName.text = intent.getStringExtra("cropName")
        tvLocation.text = intent.getStringExtra("location")
        tvAmount.text = intent.getStringExtra("amount")

    }

    private fun deleteRecord(
        id: String
    ){
        val dbRef = FirebaseDatabase.getInstance().getReference("cropOrders").child(id)
        val mTask = dbRef.removeValue()

        mTask.addOnSuccessListener {
            Toast.makeText(this, "Employee data deleted", Toast.LENGTH_LONG).show()

            val intent = Intent(this, FetchingCropActivity::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener{ error ->
            Toast.makeText(this, "Deleting Err ${error.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun openUpdateDialog(
        Orderid: String,
        name: String
    ) {
        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.crop_update_dialog, null)

        mDialog.setView(mDialogView)

        val etname = mDialogView.findViewById<EditText>(R.id.etname)
        val etCropName = mDialogView.findViewById<EditText>(R.id.etCropName)
        val etlocation = mDialogView.findViewById<EditText>(R.id.etlocation)
        val etamount = mDialogView.findViewById<EditText>(R.id.etamount)

        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)

        etCropName.setText(intent.getStringExtra("name").toString())
        etCropName.setText(intent.getStringExtra("cropName").toString())
        etlocation.setText(intent.getStringExtra("location").toString())
        etamount.setText(intent.getStringExtra("amount").toString())

        mDialog.setTitle("Updating $name Record")

        val alertDialog = mDialog.create()
        alertDialog.show()

        btnUpdateData.setOnClickListener {
            updateEmpData(
                Orderid,
                etname.text.toString(),
                etCropName.text.toString(),
                etlocation.text.toString(),
                etamount.text.toString()
            )

            Toast.makeText(applicationContext, "Crop Data Updated", Toast.LENGTH_LONG).show()

            //we are setting updated data to our textviews
            tvName.text = etname.text.toString()
            tvCropName.text = etCropName.text.toString()
            tvLocation.text = etlocation.text.toString()
            tvAmount.text = etamount.text.toString()

            alertDialog.dismiss()
        }
    }

    private fun updateEmpData(
        id: String,
        name: String,
        cropName: String,
        location: String,
        amount: String
    ) {
        val dbRef = FirebaseDatabase.getInstance().getReference("cropOrders").child(id)
        val empInfo = CropModel(id, name, cropName, location, amount)
        dbRef.setValue(empInfo)
    }


}