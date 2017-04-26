package com.example.feng.kotlinsqlite

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.feng.kotlinsqlite.db.DBHelper
import com.example.feng.kotlinsqlite.db.User
import com.example.feng.kotlinsqlite.repositories.UserRepo

import kotlinx.android.synthetic.main.activity_add.*

import org.jetbrains.anko.ctx
import org.jetbrains.anko.toast
import org.jetbrains.anko.startActivity


class AddAct : AppCompatActivity() {

    var db= DBHelper(ctx)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
/*        db.writableDatabase.dropTable("Users", true)
        db.onCreate(db.writableDatabase)*/
        btnUsers.setOnClickListener { startActivity<UserListActivity>() }
    }


    fun btnAddClick(v: View) {
        val newId = UserRepo(ctx).insert(
                User(0,etName.text.toString(),etAge.text.toString().toLong(),(if(rb1.isChecked) 1 else 0))
        )
        var msg= if (newId >-1) ("成功，id=" + newId) else "失败！"
        toast("插入"+msg)
    }
}
