package com.michelle.motionx

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChallengesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenges)

        // =====================================================
        // BACK
        // =====================================================

        findViewById<TextView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // =====================================================
        // CHALLENGE FILTERS
        // =====================================================

        findViewById<TextView>(R.id.tabActive).setOnClickListener {
            showMessage("Active Challenges")
        }

        findViewById<TextView>(R.id.tabUpcoming).setOnClickListener {
            showMessage("Upcoming Challenges")
        }

        findViewById<TextView>(R.id.tabCompleted).setOnClickListener {
            showMessage("Completed Challenges")
        }

        // =====================================================
        // ACTIVE CHALLENGE
        // =====================================================

        findViewById<TextView>(R.id.btnViewSeptember).setOnClickListener {
            showMessage("September 50K 🔥")
        }

        // =====================================================
        // DISCOVER CHALLENGES
        // =====================================================

        findViewById<TextView>(R.id.btnJoinStreak).setOnClickListener {
            showMessage("7-Day Move Streak joined 🔥")
        }

        findViewById<TextView>(R.id.btnJoinWeekend).setOnClickListener {
            showMessage("Weekend Warrior joined 🔥")
        }

        findViewById<TextView>(R.id.btnJoinEarlyBird).setOnClickListener {
            showMessage("Early Bird Challenge joined 🔥")
        }

        // =====================================================
        // LEADERBOARD
        // =====================================================

        findViewById<TextView>(R.id.btnChallengeLeaderboard).setOnClickListener {
            showMessage("Challenge Leaderboard")
        }

        // =====================================================
        // BOTTOM NAVIGATION
        // =====================================================

        findViewById<TextView>(R.id.navHome).setOnClickListener {

            val intent = Intent(
                this,
                HomeActivity::class.java
            )

            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_SINGLE_TOP

            startActivity(intent)
            finish()
        }

        findViewById<TextView>(R.id.navCommunity).setOnClickListener {

            val intent = Intent(
                this,
                CommunityActivity::class.java
            )

            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_SINGLE_TOP

            startActivity(intent)
            finish()
        }

        findViewById<TextView>(R.id.navAdd).setOnClickListener {
            showMessage("Start Activity 🔥")
        }

        findViewById<TextView>(R.id.navProgress).setOnClickListener {
            showMessage("Progress")
        }

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