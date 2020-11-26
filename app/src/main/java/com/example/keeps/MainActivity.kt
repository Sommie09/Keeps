package com.example.keeps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var add_keeps: FloatingActionButton
    private lateinit var keeps_rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_keeps = findViewById(R.id.add_keeps)
        keeps_rv = findViewById(R.id.keeps_rv)

       
    }
}