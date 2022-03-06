package com.example.crudandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter:RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    private var stdList: ArrayList<StudentClass> = ArrayList()

    fun addItems(items: ArrayList<StudentClass>){
        this.stdList = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  StudentViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.card_item_std,parent,false)
    )

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val std = stdList[position]
        holder.bindView(std)
    }

    override fun getItemCount(): Int {
        return stdList.size
    }


    class StudentViewHolder(var view:View):RecyclerView.ViewHolder(view){

        private var id = view.findViewById<TextView>(R.id.tvId)
        private var name = view.findViewById<TextView>(R.id.tvName)
        private var email = view.findViewById<TextView>(R.id.tvEmail)
        private var btnDelete = view.findViewById<TextView>(R.id.btnDelete)

        fun bindView(std:StudentClass){
            id.text = std.id.toString()
            name.text = std.name
            email.text = std.email

        }

    }


}