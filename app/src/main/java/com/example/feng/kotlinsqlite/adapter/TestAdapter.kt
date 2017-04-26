package com.example.feng.kotlinsqlite

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * Created by feng on 2017/4/18.
 */
class TestAdapter(val list: List<Map<String, Any>>, val context: Context) : BaseAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var holder: ViewHolder
        var v: View
        if (convertView == null) {
            v = View.inflate(context, R.layout.user, null)
            holder = ViewHolder(v)
            v.tag = holder
        } else {
            v = convertView
            holder = v.tag as ViewHolder
        }

        holder.id.text = list[position]["tvId"].toString()
        holder.name.text = list[position]["tvName"].toString()
        holder.age.text = list[position]["tvAge"].toString()
        holder.gender.text = list[position]["tvGender"].toString()

        return v
    }

    override fun getItem(position: Int): Any? {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}

class ViewHolder(viewItem: View) {
    var id: TextView = viewItem.findViewById(R.id.tvId) as TextView
    var name: TextView = viewItem.findViewById(R.id.tvName) as TextView
    var age: TextView = viewItem.findViewById(R.id.tvAge) as TextView
    var gender: TextView = viewItem.findViewById(R.id.tvGender) as TextView
}