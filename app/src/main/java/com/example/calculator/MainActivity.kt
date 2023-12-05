package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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

    fun equal(view: View) {
        
    }
}