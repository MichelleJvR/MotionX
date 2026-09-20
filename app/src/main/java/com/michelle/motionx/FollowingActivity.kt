package com.michelle.motionx

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FollowingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_following)

        // =====================================================
        // COMMUNITY TABS
        // =====================================================

        findViewById<TextView>(R.id.tabDiscover).setOnClickListener {
            val intent = Intent(this, CommunityActivity::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        findViewById<TextView>(R.id.tabFollowing).setOnClickListener {
            // Already on Following
        }

        findViewById<TextView>(R.id.tabChallenges).setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ChallengesActivity::class.java
                )
            )
        }

        // =====================================================
        // SHARE ACTIVITY
        // =====================================================

        findViewById<TextView>(R.id.btnShareActivity).setOnClickListener {
            showMessage("Share Activity coming soon 🔥")
        }

        // =====================================================
        // ALEX POST
        // =====================================================

        findViewById<TextView>(R.id.btnAlexProfile).setOnClickListener {
            showMessage("Alex's profile")
        }

        findViewById<TextView>(R.id.btnAlexReact).setOnClickListener {
            showMessage("You reacted 🔥")
        }

        findViewById<TextView>(R.id.btnAlexComment).setOnClickListener {
            showMessage("Comments coming soon")
        }

        findViewById<TextView>(R.id.btnAlexShare).setOnClickListener {
            showMessage("Share activity")
        }

        // =====================================================
        // SARAH POST
        // =====================================================

        findViewById<TextView>(R.id.btnSarahProfile).setOnClickListener {
            showMessage("Sarah's profile")
        }

        findViewById<TextView>(R.id.btnSarahReact).setOnClickListener {
            showMessage("You reacted 🔥")
        }

        findViewById<TextView>(R.id.btnSarahComment).setOnClickListener {
            showMessage("Comments coming soon")
        }

        findViewById<TextView>(R.id.btnSarahShare).setOnClickListener {
            showMessage("Share activity")
        }

        // =====================================================
        // CHALLENGE ACHIEVEMENT
        // =====================================================

        findViewById<TextView>(R.id.btnViewChallenge).setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ChallengesActivity::class.java
                )
            )
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