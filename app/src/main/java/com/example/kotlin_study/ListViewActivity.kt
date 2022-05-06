package com.example.kotlin_study

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val personList = ArrayList<Person>()
        for(i in 0 until 20){
            personList.add(Person(""+i+"번째사람",""+i+"번째번호"))
        }

        val adapter = ListViewAdapter(personList,this)
        val listview = findViewById<ListView>(R.id.listview)
        listview.adapter = adapter
    }
}


class ListViewAdapter (val personlist : ArrayList<Person>,val context: Context) : BaseAdapter(){

    override fun getCount(): Int {
        return personlist.size
    }

    override fun getItem(position: Int): Any {
        return personlist.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.phonebook_item,null)
        var personname = view.findViewById<TextView>(R.id.pbitem_name)
        var personnumber = view.findViewById<TextView>(R.id.pbitem_num)
        personname.setText(personlist.get(position).name)
        personnumber.setText(personlist.get(position).number)
        return view
    }

}