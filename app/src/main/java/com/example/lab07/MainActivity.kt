package com.example.lab07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.*

class MainActivity : AppCompatActivity() {
    val studentList = arrayListOf<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentData()
        recycler_view.adapter = StudentsAdapter(this.studentList,applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
    }
    fun studentData(){
        studentList.add(Student("613202533-0","Alice",20) )
        studentList.add(Student("613020543-2","Bob",21))
    }
    fun addStudent(view:View){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout,null)
        val myBuilder = AlertDialog.Builder(this)
        myBuilder.setView(mDialogView)

        val mAlertDialog=myBuilder.show()
        mAlertDialog.btnAdd.setOnClickListener(){
            studentList.add(
                Student(
                    mAlertDialog.edit_id.text.toString(),
                    mAlertDialog.edit_name.text.toString(),
                    mAlertDialog.edit_age.text.toString().toInt()
                )
            )
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(
                applicationContext,
                "The stusent is added successfully",
                Toast.LENGTH_LONG
            ).show()
            mAlertDialog.btnCancle.setOnClickListener {
                mAlertDialog.dismiss()
            }
        }

    }
}