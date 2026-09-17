package com.michelle.motionx

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // BACK BUTTON
        val btnBack = findViewById<TextView>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }

        // CREATE ACCOUNT BUTTON
        val btnCreateAccount =
            findViewById<TextView>(R.id.btnCreateAccount)

        btnCreateAccount.setOnClickListener {

            val intent = Intent(
                this@LoginActivity,
                RegisterActivity::class.java
            )

            startActivity(intent)
        }
    }
}