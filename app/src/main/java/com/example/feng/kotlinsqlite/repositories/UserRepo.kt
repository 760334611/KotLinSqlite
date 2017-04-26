package com.example.feng.kotlinsqlite.repositories

import android.content.Context
import com.example.feng.kotlinsqlite.db.DBHelper
import com.example.feng.kotlinsqlite.db.User
import org.jetbrains.anko.db.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by feng on 2017/4/26.
 */
class UserRepo(ctx: Context){
    val db=DBHelper(ctx)

    fun insert(t: User):Long {
        return db.writableDatabase.insert("Users",
                    "name" to t.name,
                    "age" to t.age,
                    "gender" to t.gender)
    }

    fun GetList(where:String=""):List<User>{
        return db.writableDatabase.select("Users","*").where(where).parseList(classParser<User>())
    }

    fun update(where:String):Boolean{

        val currentTime = Date()
        val formatter = SimpleDateFormat("yyMMdd HH:mm:ss")
        val dateString = formatter.format(currentTime)
      return  db.writableDatabase.update("Users","name" to "feng"+ dateString).where(where).exec()>0
    }

    fun delete(where:String):Boolean{
        return  db.writableDatabase.delete("Users",where)>0
    }
}