package com.example.reviseme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvDisplay: TextView
    private var strNumber = StringBuilder()
    private lateinit var numberButtons: Array<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val num1: Int = 5
        var num2: Int
        num2 = 10

        val sum: Int = num1 + num2
        tvDisplay = findViewById(R.id.tvDisplay)
        tvDisplay.text = sum.toString()
        initializeComponents()


    }

    private fun initializeComponents() {
        val button9: Button = findViewById(R.id.button9)
        val button8: Button = findViewById(R.id.button8)
        val button7: Button = findViewById(R.id.button7)
        val button6: Button = findViewById(R.id.button6)
        val button5: Button = findViewById(R.id.button5)
        val button4: Button = findViewById(R.id.button4)
        val button3: Button = findViewById(R.id.button3)
        val button2: Button = findViewById(R.id.button2)
        val button1: Button = findViewById(R.id.button1)
        val button0: Button = findViewById(R.id.button0)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSub: Button = findViewById(R.id.buttonSub)

        numberButtons = arrayOf(button9,button8,button7,button6,
            button5,button4,button3,button2,button1,button0)

        for(button in numberButtons){
            button.setOnClickListener {
                buttonNumberClicked(button)
            }
        }
    }

    private fun buttonNumberClicked(btn:Button) {
        strNumber.append(btn.text)
        tvDisplay.text = strNumber
    }
}