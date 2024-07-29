package com.example.reviseme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val num1: Int = 5
        var num2: Int
        num2 = 10

        val sum: Int = num1 + num2
        val tvDisplay: TextView = findViewById(R.id.tvDisplay)
        tvDisplay.text = sum.toString()

    }
}