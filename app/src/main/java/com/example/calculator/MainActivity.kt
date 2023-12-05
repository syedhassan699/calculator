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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvin =findViewById(R.id.tvin)
    }

    fun click(view: View) {
       tvin?.append((view as Button).text)
    }
    fun clear(view: View) {
        tvin?.text = ""
    }

    @SuppressLint("SetTextI18n")
    fun sum(view: View) {
        val tvNew = tvin?.text.toString()
        try {
            val splitValue = tvNew.split("+")
            var one = splitValue[0]
            var two = splitValue[1]
            tvin?.text = (one + two).toInt().toString()
        }catch (e:ArithmeticException)
        {e.printStackTrace()}
        println()
    }
}
