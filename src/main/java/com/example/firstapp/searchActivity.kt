package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class searchActivity : AppCompatActivity() {
    private lateinit var etSearch:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val btnSearch = findViewById<Button>(R.id.btnSearch)
        etSearch=findViewById(R.id.etSearch)
        btnSearch.setOnClickListener {
            val intent = Intent(this, resultActivity::class.java)

            intent.putExtra("word",etSearch.text.toString())
            startActivity(intent)
        }
    }
}
