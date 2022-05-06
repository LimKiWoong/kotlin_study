package com.example.kotlin_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PhoneBookDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_phone_book_detail)

        val back = findViewById<Button>(R.id.back)

        getPersonInfo()
        back.setOnClickListener {
            // 뒤로가기
            onBackPressed()
        }

    }

    fun getPersonInfo(){
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")
        var persondetailname = findViewById<TextView>(R.id.detail_name)
        var persondetailnumber = findViewById<TextView>(R.id.detail_number)
        persondetailname.setText(name)
        persondetailnumber.setText(number)

    }
}