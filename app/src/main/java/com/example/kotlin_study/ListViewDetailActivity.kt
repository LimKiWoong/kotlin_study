package com.example.kotlin_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ListViewDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_detail)

        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        val detailname = findViewById<TextView>(R.id.listnamedetail)
        val detailnumber = findViewById<TextView>(R.id.listnumberdetail)
        val backbutton = findViewById<Button>(R.id.listback)

        detailname.setText(name)
        detailnumber.setText(number)
        backbutton.setOnClickListener {
            onBackPressed()
        }


    }
}