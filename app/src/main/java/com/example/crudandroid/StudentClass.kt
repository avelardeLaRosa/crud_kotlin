package com.example.crudandroid

import java.util.*

data class StudentClass(
    var id   : Int    = getAutoId(),
    var name : String = "",
    var email: String = ""

){

    companion object{
        fun getAutoId():Int{
            val random = Random()
            return random.nextInt(100)
        }
    }



}
