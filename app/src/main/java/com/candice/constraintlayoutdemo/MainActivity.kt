package com.candice.constraintlayoutdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader



class MainActivity : AppCompatActivity() {
    //  private lateinit var data:
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = initData()
        Log.e("TAG", "dat>>>$data")
//        val dataBean= Gson().fromJson<DataBean>(data, object : TypeToken<List<DataBean>>() {}.type)
//        val list = Utils().gsonToList<DataBeanNew>(gsonString = data, type = object : TypeToken<List<DataBeanNew>>() {}.type)
        val list = GsonConvert.method(data)
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = DataAdapter2(this )
        adapter.setData(list)
        rv.layoutManager = manager
        rv.adapter = adapter

    }

    private fun initData(): String {
        val builder = StringBuilder()
        val stream = assets.open("data2.json")
        val reader = BufferedReader(InputStreamReader(stream))
        var line:String? = ""
        do {
            line = reader.readLine()
            if (!TextUtils.isEmpty(line)) {
                builder.append(line)
            } else {
                break
            }
        } while (true)

        return builder.toString()


    }



}
