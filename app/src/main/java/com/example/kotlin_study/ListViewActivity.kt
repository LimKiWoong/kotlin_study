package com.example.kotlin_study

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val personList = ArrayList<Person>()
        for (i in 0 until 20) {
            personList.add(Person("" + i + "번째사람", "" + i + "번째번호"))
        }

        val adapter = ListViewAdapter(personList, this,layoutInflater)
        val listview = findViewById<ListView>(R.id.listview)
        listview.adapter = adapter
        listview.setOnItemClickListener { parent, view, position, id ->
            // 캐스팅
            val pname = (adapter.getItem(position) as Person).name
            // 토스트메세지
            Toast.makeText(this, pname, Toast.LENGTH_LONG).show()

            val intent = Intent(this, ListViewDetailActivity::class.java)
            intent.putExtra("name", adapter.personlist.get(position).name)
            intent.putExtra("number", adapter.personlist.get(position).number)
            startActivity(intent)
        }
    }
}


class ListViewAdapter(
    val personlist: ArrayList<Person>,
    val context: Context,
    val layoutInflater: LayoutInflater
) : BaseAdapter() {

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
        //findviewbyid를 사용하는 방법
//        val layoutInflater = LayoutInflater.from(context)
//        val view = layoutInflater.inflate(R.layout.phonebook_item,null)
////        var personname = view.findViewById<TextView>(R.id.pbitem_name)
////        var personnumber = view.findViewById<TextView>(R.id.pbitem_num)
//        personname.setText(personlist.get(position).name)
//        personnumber.setText(personlist.get(position).number)
//        return view

        // findviewbyid 를 이용하는것은 리소스를 많이 잡아먹기때문에 viewholder를 사용한다.
        val view: View
        val holder: ViewHoler
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.phonebook_item, null)
            holder = ViewHoler()

            holder.personName = view.findViewById(R.id.pbitem_name)
            holder.personNumber = view.findViewById(R.id.pbitem_num)

            view.tag = holder
        } else {
            holder = convertView.tag as ViewHoler
            view = convertView
        }
        holder.personName?.setText(personlist[position].name)
        holder.personNumber?.setText(personlist.get(position).number)

        return view
    }

}
// findviewbyid 를 이용하는것은 리소스를 많이 잡아먹기때문에 viewholder를 사용한다.
class ViewHoler {
    var personName: TextView? = null
    var personNumber: TextView? = null
}