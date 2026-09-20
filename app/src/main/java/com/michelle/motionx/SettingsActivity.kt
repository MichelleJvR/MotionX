package com.michelle.motionx

import android.content.Intent
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // BACK
        findViewById<TextView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // EDIT PROFILE
        findViewById<TextView>(R.id.btnEditProfile).setOnClickListener {
            showMessage("Edit Profile")
        }

        // ACTIVITY & GOALS
        findViewById<TextView>(R.id.rowWeeklyGoal).setOnClickListener {
            showMessage("Weekly Goal")
        }

        findViewById<TextView>(R.id.rowPreferredActivity).setOnClickListener {
            showMessage("Preferred Activity")
        }

        findViewById<TextView>(R.id.rowUnits).setOnClickListener {
            showMessage("Units")
        }

        // APP PREFERENCES
        findViewById<TextView>(R.id.rowAppearance).setOnClickListener {
            showMessage("Appearance")
        }

        findViewById<TextView>(R.id.rowLanguage).setOnClickListener {
            showMessage("Language")
        }

        // NOTIFICATION SWITCHES
        val switchActivityReminders =
            findViewById<Switch>(R.id.switchActivityReminders)

        val switchGoalUpdates =
            findViewById<Switch>(R.id.switchGoalUpdates)

        val switchChallengeUpdates =
            findViewById<Switch>(R.id.switchChallengeUpdates)

        switchActivityReminders.setOnCheckedChangeListener { _, checked ->
            if (checked) {
                showMessage("Activity reminders enabled")
            } else {
                showMessage("Activity reminders disabled")
            }
        }

        switchGoalUpdates.setOnCheckedChangeListener { _, checked ->
            if (checked) {
                showMessage("Goal updates enabled")
            } else {
                showMessage("Goal updates disabled")
            }
        }

        switchChallengeUpdates.setOnCheckedChangeListener { _, checked ->
            if (checked) {
                showMessage("Challenge updates enabled")
            } else {
                showMessage("Challenge updates disabled")
            }
        }

        // PRIVACY & SECURITY
        findViewById<TextView>(R.id.rowLocation).setOnClickListener {
            showMessage("Location & GPS")
        }

        findViewById<TextView>(R.id.rowPrivacy).setOnClickListener {
            showMessage("Privacy")
        }

        findViewById<TextView>(R.id.rowChangePassword).setOnClickListener {
            showMessage("Change Password")
        }

        // SUPPORT
        findViewById<TextView>(R.id.rowHelp).setOnClickListener {
            showMessage("Help & Support")
        }

        findViewById<TextView>(R.id.rowAbout).setOnClickListener {
            showMessage("MotionX Version 1.0.0")
        }

        // SIGN OUT
        findViewById<TextView>(R.id.btnSignOut).setOnClickListener {
            showMessage("Sign Out")
        }

        // BOTTOM NAVIGATION
        findViewById<TextView>(R.id.navHome).setOnClickListener {

            val intent =
                Intent(this, HomeActivity::class.java)

            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_SINGLE_TOP

            startActivity(intent)

            finish()
        }

        findViewById<TextView>(R.id.navProgress).setOnClickListener {
            showMessage("Progress")
        }

        findViewById<TextView>(R.id.navAdd).setOnClickListener {
            showMessage("Start Activity 🔥")
        }

        findViewById<TextView>(R.id.navChallenges).setOnClickListener {
            showMessage("Challenges")
        }

        findViewById<TextView>(R.id.navProfile).setOnClickListener {
            showMessage("Profile")
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