package com.michelle.motionx

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnBack = findViewById<TextView>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }
    }
}