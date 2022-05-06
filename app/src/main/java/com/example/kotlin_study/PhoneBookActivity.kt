package com.example.kotlin_study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)


        createPhoneBookList(createFakePhoneBook())

    }

    fun createFakePhoneBook(fakeNumber: Int = 10,phoneBook: PhoneBook = PhoneBook()) : PhoneBook {
        for (i in 0 until fakeNumber){
            phoneBook.addPerson(
                Person(""+i+"번째 이름",""+i+"번째 번호")
            )
        }
        return phoneBook
    }


    fun createPhoneBookList(phoneBook: PhoneBook) {
        val container = findViewById<LinearLayout>(R.id.phonebook_container)
        val layoutInflater = LayoutInflater.from(this)
        for (i in 0 until phoneBook.phoneBookList.size) {
            //아이템 하나에들어갈 뷰 인플레이트
            val item = layoutInflater.inflate(R.layout.phonebook_item,null)
            //아이템 하나하나 이름과번호를 부여
            val item_name = item.findViewById<TextView>(R.id.pbitem_name)
            val item_number = item.findViewById<TextView>(R.id.pbitem_num)
            item_name.setText(phoneBook.phoneBookList.get(i).name)
            item_number.setText(phoneBook.phoneBookList.get(i).number)
            //아이템클릭 리스너달기
            addSetonClickListener(phoneBook.phoneBookList.get(i), item)
            //컨테이너에 하나씩 추가
            container.addView(item)
        }
    }

    fun addSetonClickListener(person: Person,view: View){
        view.setOnClickListener {
            val intent = Intent(this,PhoneBookDetailActivity::class.java)
            intent.putExtra("name",person.name)
            intent.putExtra("number",person.number)
            startActivity(intent)
        }
    }

}

// Person을 넣어줄 phonebook
class PhoneBook() {
    val phoneBookList = ArrayList<Person>()

    fun addPerson(person: Person) {
        phoneBookList.add(person)
    }
}

class Person(val name: String, val number: String) {

}