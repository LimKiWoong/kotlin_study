package com.example.kotlin_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

        createPhoneBookList(createFakePhoneBook())
    }

    fun createFakePhoneBook(fakeNumber: Int =10, phoneBook: PhoneBook = PhoneBook()) : PhoneBook {
        for ( i in 0 until fakeNumber){
            // phonebook에 정보 삽입
            phoneBook.addPerson(
                Person(""+i+"번째 사람",""+i+"번째 번호")
            )
        }
        return phoneBook
    }

    fun createPhoneBookList(phoneBook : PhoneBook){
        val layoutInflater = LayoutInflater.from(this)
        val container = findViewById<LinearLayout>(R.id.phonebook_container)
        for(i in 0 until phoneBook.personList.size){
            //아이템 하나에들어갈 뷰 인플레이트
            val view = layoutInflater.inflate(R.layout.phonebook_item,null)
            val itemname = view.findViewById<TextView>(R.id.pbitem_name)
            val itemnumber = view.findViewById<TextView>(R.id.pbitem_num)
            //아이템 하나하나 이름과번호를 부여
            itemname.setText(phoneBook.personList.get(i).name)
            itemnumber.setText(phoneBook.personList.get(i).number)
            //컨테이너에 하나씩 추가
            container.addView(view)

        }
    }

}

// Person을 넣어줄 phonebook
class PhoneBook(){
    val personList = ArrayList<Person>()

    fun addPerson(person: Person){
        personList.add(person)
    }
}

class Person (val name: String, val number: String){

}