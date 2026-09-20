package com.michelle.motionx

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // SETTINGS
        findViewById<TextView>(R.id.btnSettings).setOnClickListener {
            startActivity(
                Intent(this, SettingsActivity::class.java)
            )
        }

        // EDIT PROFILE
        findViewById<TextView>(R.id.btnEditProfile).setOnClickListener {
            showMessage("Edit Profile")
        }

        // PERSONAL BESTS
        findViewById<TextView>(R.id.btnSeeAllPBs).setOnClickListener {
            showMessage("Personal Bests")
        }

        // ACHIEVEMENTS
        findViewById<TextView>(R.id.btnSeeAllAchievements).setOnClickListener {
            showMessage("Achievements")
        }

        // HOME
        findViewById<TextView>(R.id.navHome).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)

            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_SINGLE_TOP

            startActivity(intent)
            finish()
        }

        // PROGRESS
        findViewById<TextView>(R.id.navProgress).setOnClickListener {
            showMessage("Progress")
        }

        // ADD ACTIVITY
        findViewById<TextView>(R.id.navAdd).setOnClickListener {
            showMessage("Start Activity 🔥")
        }

        // CHALLENGES
        findViewById<TextView>(R.id.navChallenges).setOnClickListener {
            showMessage("Challenges")
        }

        // PROFILE
        findViewById<TextView>(R.id.navProfile).setOnClickListener {
            // Already on Profile
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