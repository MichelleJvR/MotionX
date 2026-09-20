package com.michelle.motionx

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CommunityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_community
        )

        findViewById<TextView>(
            R.id.tabDiscover
        ).setOnClickListener {
        }

        findViewById<TextView>(
            R.id.tabFollowing
        ).setOnClickListener {

            startActivity(
                Intent(
                    this,
                    FollowingActivity::class.java
                )
            )
        }

        findViewById<TextView>(
            R.id.tabChallenges
        ).setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ChallengesActivity::class.java
                )
            )
        }

        findViewById<TextView>(
            R.id.btnExploreCommunity
        ).setOnClickListener {

            startActivity(
                Intent(
                    this,
                    DiscoverAthletesActivity::class.java
                )
            )
        }

        findViewById<TextView>(
            R.id.btnSeeAllChallenges
        ).setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ChallengesActivity::class.java
                )
            )
        }

        findViewById<TextView>(
            R.id.btnJoinSeptember
        ).setOnClickListener {

            showMessage(
                "September 50K joined 🔥"
            )
        }

        findViewById<TextView>(
            R.id.btnJoinStreak
        ).setOnClickListener {

            showMessage(
                "7-Day Move Streak joined 🔥"
            )
        }

        findViewById<TextView>(
            R.id.btnLeaderboard
        ).setOnClickListener {

            startActivity(
                Intent(
                    this,
                    LeaderboardActivity::class.java
                )
            )
        }

        findViewById<TextView>(
            R.id.btnDiscoverPeople
        ).setOnClickListener {

            startActivity(
                Intent(
                    this,
                    DiscoverAthletesActivity::class.java
                )
            )
        }

        findViewById<TextView>(
            R.id.btnGroups
        ).setOnClickListener {

            startActivity(
                Intent(
                    this,
                    GroupsActivity::class.java
                )
            )
        }

        findViewById<TextView>(
            R.id.navHome
        ).setOnClickListener {

            val intent =
                Intent(
                    this,
                    HomeActivity::class.java
                )

            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_SINGLE_TOP

            startActivity(intent)

            finish()
        }

        findViewById<TextView>(
            R.id.navCommunity
        ).setOnClickListener {
        }

        findViewById<TextView>(
            R.id.navAdd
        ).setOnClickListener {

            showMessage(
                "Start Activity 🔥"
            )
        }

        findViewById<TextView>(
            R.id.navProgress
        ).setOnClickListener {

            showMessage(
                "Progress"
            )
        }

        findViewById<TextView>(
            R.id.navProfile
        ).setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ProfileActivity::class.java
                )
            )
        }
    }

    private fun showMessage(
        message: String
    ) {

        Toast.makeText(
            this,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }
}