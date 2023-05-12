package com.example.agriapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agriapp.CropDetailsActivity
import com.example.agriapp.R
import com.example.agriapp.adapters.CropAdapter
import com.example.agriapp.models.CropModel
//import com.google.firebase.database.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FetchingCropActivity : AppCompatActivity() {

    private lateinit var empRecycleView: RecyclerView
    private lateinit var tvLoadingData : TextView
    private lateinit var cropList: ArrayList<CropModel>
    private  lateinit var dbRef: DatabaseReference

//    @SuppressLint("WrongViewCast")
//    @SuppressLint("MissingInflatedId")
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crop_fetching)

        empRecycleView = findViewById(R.id.rvEmp)
        empRecycleView.layoutManager = LinearLayoutManager(this)
        empRecycleView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

    cropList = arrayListOf<CropModel>()

        getEmployeeData()

    }

    private fun getEmployeeData(){
        empRecycleView.visibility = View.GONE
        tvLoadingData.visibility  = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("cropOrders")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                cropList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(CropModel::class.java)
                        cropList.add(empData!!)
                    }
                    val mAdapter = CropAdapter(cropList)
                    empRecycleView.adapter = mAdapter

                    mAdapter.setOnItemClickListner(object :CropAdapter.onItemClickLisner{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@FetchingCropActivity, CropDetailsActivity::class.java)

//                            put extras
                            intent.putExtra("Orderid",cropList[position].OrderId)
                            intent.putExtra("name",cropList[position].name)
                            intent.putExtra("cropName",cropList[position].cropName)
                            intent.putExtra("location",cropList[position].location)
                            intent.putExtra("amount",cropList[position].amount)
                            startActivity(intent)

                        }

                    })

                    empRecycleView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}