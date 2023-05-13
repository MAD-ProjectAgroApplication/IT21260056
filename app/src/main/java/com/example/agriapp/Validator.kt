package com.example.agriapp

object Validator  {
    fun validateInput ( name:String, cropName:String, location:String, amount:Int): Boolean {

        return !( amount <= 0 || name.isEmpty())
    }
}