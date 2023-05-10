package com.example.agriapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agriapp.R
import com.example.agriapp.models.CropModel

class CropAdapter (private val cropList:ArrayList<CropModel>):
    RecyclerView.Adapter<CropAdapter.ViewHolder>(){

    /////retrive to editor mode
    private lateinit var mListner : onItemClickLisner

    interface onItemClickLisner{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListner(clickListner : onItemClickLisner) {
        mListner = clickListner
    }

    ///////sent and get data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_my_order,parent,false)
        return ViewHolder(itemView,mListner)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentEmp = cropList[position]
        holder.tvCropName.text = currentEmp.name
    }

    override fun getItemCount(): Int {
        return cropList.size
    }


    class ViewHolder(itemView:View,clickLisner: onItemClickLisner) : RecyclerView.ViewHolder(itemView) {
        val tvCropName :TextView = itemView.findViewById(R.id.tvCropName)

        init {
            itemView.setOnClickListener{
                clickLisner.onItemClick(adapterPosition)
            }
        }


    }




}