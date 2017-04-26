package com.example.feng.kotlinsqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.feng.kotlinsqlite.repositories.UserRepo

import kotlinx.android.synthetic.main.activity_user_list.*
import org.jetbrains.anko.ctx
import java.util.ArrayList


class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        var userList =UserRepo(ctx).GetList()
        val list = ArrayList<Map<String, Any>>()
        userList.mapTo(list) {hashMapOf<String, Any>(
                    "tvId" to  it._id,
                    "tvName" to  it.name,
                    "tvAge" to  it.age,
                    "tvGender" to it.gender)}
        lv.adapter =  TestAdapter(list,this)
    }
}
