package com.example.agriapp.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agriapp.R
import com.example.agriapp.models.CropModel
import com.google.firebase.database.*

class FetchingCropActivity : AppCompatActivity() {

    private lateinit var empRecycleView: RecyclerView
    private lateinit var tvLoadingData : TextView
    private lateinit var empList: ArrayList<CropModel>
    private  lateinit var dbRef: DatabaseReference

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_order)

//        empRecycleView = findViewById(R.id.rvEmp)
//        empRecycleView.layoutManager = LinearLayoutManager(this)
//        empRecycleView.setHasFixedSize(true)
//        tvLoadingData = findViewById(R.id.tvLoadingData)

        empList = arrayListOf<CropModel>()

//        getEmployeeData()

//        val update = findViewById<Button>(R.id.button9)
//        update.setOnClickListener {
//            val Intent = Intent(this,updateDetails::class.java)
//            startActivity(Intent)
//        }
    }

//    private fun getEmployeeData(){
//        empRecycleView.visibility = View.GONE
//        tvLoadingData.visibility  = View.VISIBLE
//
//        dbRef = FirebaseDatabase.getInstance().getReference("cropOrders")
//
//        dbRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                empList.clear()
//                if (snapshot.exists()){
//                    for (empSnap in snapshot.children){
//                        val empData = empSnap.getValue(OrderCrops::class.java)
//                        empList.add(empData!!)
//                    }
////                    val mAdapter = EmpAdapter(empList)
////                    empRecycleView.adapter = mAdapter
////
////                    mAdapter.setOnItemClickListner(object :EmpAdapter.onItemClickLisner{
////                        override fun onItemClick(position: Int) {
////                            val intent = Intent(this@FetchingCropDetailsActivity, CropDetailsActivity::class.java)
////
////                            put extras
////                            intent.putExtra("name",empList[position].name)
////                            intent.putExtra("cropName",empList[position].cropName)
////                            intent.putExtra("location",empList[position].location)
////                            intent.putExtra("amount",empList[position].amount)
////                            startActivity(intent)
////
////                        }
//
////                    })
//
//                    empRecycleView.visibility = View.VISIBLE
//                    tvLoadingData.visibility = View.GONE
//                }
//            }
//
////            override fun onCancelled(error: DatabaseError) {
////                TODO("Not yet implemented")
////            }
//
//        })
//    }
}