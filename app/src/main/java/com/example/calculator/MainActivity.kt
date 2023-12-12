package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    var tvin:TextView ? = null

    var lastNumeric : Boolean = false
    var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvin =findViewById(R.id.tvin)
    }

    fun click(view: View) {
       tvin?.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }
    fun clear(view: View) {
        tvin?.text = ""
    }

    fun onDecimalPoint(view: View){
        if (lastNumeric && !lastDot){
            tvin?.append(".")
            lastNumeric = false
            lastDot = true

        }
    }

    fun onOperator(view: View){
        tvin?.text?.let {
            if (lastNumeric && !isOperatorAdded(it.toString())){
                tvin?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }

    }
    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")){
            false
        }else{
            value.contains("/") ||
            value.contains("*") ||
            value.contains("-") ||
            value.contains("+")
        }
    }
    private fun removeZeroAfterDot(result: String): String {
        var value =result
        if (result.contains(".0")){
            value = result.substring(0,result.length -2)
        }
        return value
    }

    fun onEqual (view: View){
        if (lastNumeric){
            var tvValue = tvin?.text.toString()
            var prefix = ""
            try {
                if (tvValue.startsWith("-")){
                    tvValue = tvValue.substring(1)
                }

                if (tvValue.contains("-")){
                    val splitValue = tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    tvin?.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
                }

                else if (tvValue.contains("+")){
                    val splitValue = tvValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    tvin?.text = removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())
                }

                else if (tvValue.contains("*")){
                    val splitValue = tvValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    tvin?.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())
                }

                else if (tvValue.contains("/")){
                    val splitValue = tvValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    tvin?.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())
                }

            }catch (e:ArithmeticException){
                e.printStackTrace()
            }
        }
    }
}
