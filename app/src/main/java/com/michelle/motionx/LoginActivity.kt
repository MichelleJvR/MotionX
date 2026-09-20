package com.michelle.motionx

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Back to welcome screen
        findViewById<TextView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // TEMPORARY LOGIN BYPASS
        // Firebase authentication will be connected later.
        findViewById<TextView>(R.id.btnSignIn).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // Go to registration screen
        findViewById<TextView>(R.id.btnCreateAccount).setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}