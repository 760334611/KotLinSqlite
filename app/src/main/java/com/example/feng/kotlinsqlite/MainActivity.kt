package com.example.feng.kotlinsqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.db.insert
import android.widget.Toast
import com.example.feng.kotlinsqlite.repositories.UserRepo
import org.jetbrains.anko.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners();
        //startActivity<UserListActivity>()
    }
    /**
     * 按钮监听事件
     */
    private fun initListeners() {
        btnAdd?.setOnClickListener {startActivity<AddAct>()}
        btnList?.setOnClickListener {startActivity<UserListActivity>()}
        btnEdit?.setOnClickListener {
            var list=UserRepo(ctx).GetList()
            if (list.size>0)
            {
                var ok=UserRepo(ctx).update("_id = "+list[0]._id)
                toast("修改"+ok.toString()+"转向列表")
                startActivity<UserListActivity>()
            }
            else
            {
                toast("数据库无数据，无法修改，先增加点数据")
                startActivity<AddAct>()
            }
        }
        btnDel?.setOnClickListener {

            var list=UserRepo(ctx).GetList()
            if (list.size>0)
            {
                var ok=UserRepo(ctx).delete("_id = "+list[0]._id)
                toast("删除"+ok.toString()+"转向列表")
                startActivity<UserListActivity>()
            }
            else
            {
                toast("数据库无数据，无法删除，先增加点数据")
                startActivity<AddAct>()
            }
        }

    }

/*        doAsync {
            uiThread { loadComplete(result) }
        }*/
}
