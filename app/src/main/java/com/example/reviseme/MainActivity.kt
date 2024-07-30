package com.example.reviseme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvDisplay: TextView
    private lateinit var tvGrading: TextView
    private var strNumber = StringBuilder()
    private lateinit var numberButtons: Array<Button>
    private lateinit var operatorButtons: Array<Button>
    private lateinit var specicialButtons: Array<Button>
    private var operator: Operator = Operator.NONE
    private var isOperatorClicked: Boolean = false
    private var operand1: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sum: Int = 0
        tvDisplay = findViewById(R.id.tvDisplay)
        tvGrading = findViewById(R.id.tvGrading)
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
        val buttonMul: Button = findViewById(R.id.buttonMul)
        val buttonDiv: Button = findViewById(R.id.buttonDiv)
        val buttonEquals: Button = findViewById(R.id.buttonEquals)
        val buttonDel: Button = findViewById(R.id.buttonDel)
        val buttonClear: Button = findViewById(R.id.buttonClear)
        val buttonSys: Button = findViewById(R.id.buttonSys)
        val buttonMode: Button = findViewById(R.id.buttonMode)

        numberButtons = arrayOf(
            button9, button8, button7, button6,
            button5, button4, button3, button2, button1, button0
        )

        operatorButtons = arrayOf(buttonAdd, buttonSub, buttonDiv, buttonMul)

        specicialButtons = arrayOf(buttonEquals, buttonClear, buttonDel,buttonSys,buttonMode)

        for (button in numberButtons) {
            button.setOnClickListener {
                buttonNumberClicked(button)
            }
        }

        for (btnOperator in operatorButtons) {
            btnOperator.setOnClickListener {
                operatorButtonClicked(btnOperator)
            }
        }
        for (btnSpecial in specicialButtons) {
            btnSpecial.setOnClickListener {
                specicialButtonClicked(btnSpecial)
            }
        }
    }

    private fun specicialButtonClicked(btnSpecial: Button) {

        if (btnSpecial.text == "=") {
            getTotal()
        } else if (btnSpecial.text == "CLR") {
            operator = Operator.NONE
            operand1 = 0
            strNumber.clear()
            strNumber.append("0")
            updateDisplay()
            isOperatorClicked = true
        } else if (btnSpecial.text == "Del") {

            var newStr: String = strNumber.toString().substring(0, strNumber.length - 1)

            strNumber.clear()
            strNumber.append(newStr)
            updateDisplay()

        }else if (btnSpecial.text == "ART"){
            tvGrading.text = "System: Art"
            btnSpecial.text = "SCI"
        }else if (btnSpecial.text == "SCI"){
            tvGrading.text = "System: Sci"
            btnSpecial.text = "ART"
        }else if (btnSpecial.text == "MODE"){
            if(tvGrading.text !="normal"){
                tvGrading.text = "normal"
            }else {
                tvGrading.text = "System: Sci"

            }
            specicialButtons[3].text = "ART"
        }

    }

    private fun getTotal() {
        var operand2: Int = strNumber.toString().toInt()
        var result: Int
        when (operator) {
            Operator.ADD -> result = operand1 + operand2
            Operator.SUB -> result = operand1 - operand2
            Operator.MUL -> result = operand1 * operand2
            Operator.DIV ->  result = operand1 / operand2

            else  -> result = operand2

        }
        operator = Operator.NONE
        operand1 = result
        strNumber.clear()
        strNumber.append(result.toString())
        updateDisplay()
        isOperatorClicked = true
    }

    private fun updateDisplay() {


        try {
            var newValue: Int = strNumber.toString().toInt()
            strNumber.clear()
            strNumber.append(newValue.toString())

            tvDisplay.text = strNumber
        } catch (e: IllegalArgumentException) {
            strNumber.clear()
            tvDisplay.text = "ERROR"
        }

    }

    private fun operatorButtonClicked(btnOperator: Button) {
        if(operator!=Operator.NONE){
            getTotal()
        }
        if (btnOperator.text == "+") {
           operator = Operator.ADD
        } else if (btnOperator.text == "-") {
           operator = Operator.SUB
        } else if (btnOperator.text == "*") {
            operator = Operator.MUL
        } else if (btnOperator.text == "/") {
            operator = Operator.DIV
        } else operator = Operator.NONE
        isOperatorClicked = true
//        getTotal()
    }

    private fun buttonNumberClicked(btn: Button) {
        if (isOperatorClicked) {
            operand1 = strNumber.toString().toInt()
            strNumber.clear()
            isOperatorClicked = false
        }
        strNumber.append(btn.text)
        updateDisplay()
    }
}

enum class Operator { ADD, SUB, MUL, DIV, NONE }