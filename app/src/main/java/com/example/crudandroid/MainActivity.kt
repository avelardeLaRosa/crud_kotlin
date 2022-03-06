package com.example.crudandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var  etName: EditText
    private lateinit var  etEmail: EditText
    private lateinit var  btnAdd: Button
    private lateinit var  btnView: Button

    private lateinit var sqLiteHelper: SQLiteHelper
    private lateinit var  recyclerView: RecyclerView
    private var adapter: StudentClass?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etxtName)
        etEmail = findViewById(R.id.etxtEmail)
        btnAdd = findViewById(R.id.btnIngresar)
        btnView = findViewById(R.id.btnVista)

        sqLiteHelper = SQLiteHelper(this)

        btnAdd.setOnClickListener { addStudent() }
        btnView.setOnClickListener { getStudent() }


    }

    private fun getStudent() {
        val stdList = sqLiteHelper.getAllStudent()
        Log.e("pppp", "${stdList.size}")
    }

    private fun addStudent() {
        val name = etName.text.toString()
        val email = etEmail.text.toString()

        if(name.isEmpty() || email.isEmpty()){
            Toast.makeText(this,"Ingrese el campo ",Toast.LENGTH_SHORT).show()
        }else{
            val std = StudentClass(name = name, email = email)
            val status = sqLiteHelper.insertStudent(std)

            if(status>-1){
                Toast.makeText(this,"Estudiante Agregado",Toast.LENGTH_SHORT).show()
                clearEditText()
            }else{
                Toast.makeText(this,"No guardado",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearEditText() {
        etName.setText("")
        etEmail.setText("")
    }
}