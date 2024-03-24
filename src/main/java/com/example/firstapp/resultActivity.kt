package com.example.firstapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.R
import org.json.JSONArray
import java.io.InputStream

class resultActivity : AppCompatActivity() {
    var arr=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val word : String? = intent.getStringExtra("word")
        read_json(word)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        tvResult.text = "Definition of $word"
    }
    fun read_json(str : String?)
    {
        var json : String?=null
        val s= (str?.toLowerCase())?.first()
        val inputStream:InputStream=assets.open("$s.json")
        json=inputStream.bufferedReader().use{it.readText()}
        var jsonarr=JSONArray(json)
        for(i in 0..jsonarr.length()-1)
        {
            var jsonobj=jsonarr.getJSONObject(i)
            if(jsonobj.getString("word")==str) {
                arr.add(jsonobj.getString("type")+"-"+jsonobj.getString("description"))
            }
        }
        var adpt=ArrayAdapter(this,android.R.layout.simple_list_item_1,arr)
        val json_list=findViewById<ListView>(R.id.json_list)
        json_list.adapter=adpt
    }

}
