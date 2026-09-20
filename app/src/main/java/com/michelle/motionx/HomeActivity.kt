package com.michelle.motionx

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // START ACTIVITY
        findViewById<TextView>(R.id.btnStartActivity).setOnClickListener {
            showMessage("Start Activity 🔥")
        }

        // QUICK ACTIVITIES
        findViewById<TextView>(R.id.btnRun).setOnClickListener {
            showMessage("Run selected 🏃")
        }

        findViewById<TextView>(R.id.btnWalk).setOnClickListener {
            showMessage("Walk selected 🚶")
        }

        findViewById<TextView>(R.id.btnCycle).setOnClickListener {
            showMessage("Cycle selected 🚴")
        }

        findViewById<TextView>(R.id.btnGym).setOnClickListener {
            showMessage("Gym selected 🏋")
        }

        // RECENT ACTIVITY
        findViewById<TextView>(R.id.btnSeeAllActivities).setOnClickListener {
            showMessage("All Activities")
        }

        findViewById<View>(R.id.recentActivityCard).setOnClickListener {
            showMessage("Morning Run")
        }

        // HOME
        findViewById<TextView>(R.id.navHome).setOnClickListener {
            // Already on Home
        }

        // PROGRESS
        findViewById<TextView>(R.id.navProgress).setOnClickListener {
            showMessage("Progress")
        }

        // ADD
        findViewById<TextView>(R.id.navAdd).setOnClickListener {
            showMessage("Start Activity 🔥")
        }

        // COMMUNITY
        findViewById<TextView>(R.id.navChallenges).apply {

            text = "♧\nCommunity"

            setOnClickListener {

                startActivity(
                    Intent(
                        this@HomeActivity,
                        CommunityActivity::class.java
                    )
                )
            }
        }

        // PROFILE
        findViewById<TextView>(R.id.navProfile).setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ProfileActivity::class.java
                )
            )
        }
    }

    private fun showMessage(message: String) {

        Toast.makeText(
            this,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }
}