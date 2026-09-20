package com.michelle.motionx

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DiscoverAthletesActivity : AppCompatActivity() {

    private lateinit var btnFollowAlex: TextView
    private lateinit var btnFollowSarah: TextView
    private lateinit var btnFollowJordan: TextView
    private lateinit var btnFollowThando: TextView

    private var followingAlex = false
    private var followingSarah = true
    private var followingJordan = false
    private var followingThando = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover_athletes)

        // =====================================================
        // BACK
        // =====================================================

        findViewById<TextView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // =====================================================
        // SEARCH
        // =====================================================

        val etSearch = findViewById<EditText>(R.id.etSearchAthletes)

        findViewById<TextView>(R.id.btnSearch).setOnClickListener {

            val query = etSearch.text.toString().trim()

            if (query.isEmpty()) {
                showMessage("Enter an athlete name")
            } else {
                showMessage("Searching for $query")
            }
        }

        // =====================================================
        // FOLLOW BUTTONS
        // =====================================================

        btnFollowAlex = findViewById(R.id.btnFollowAlex)
        btnFollowSarah = findViewById(R.id.btnFollowSarah)
        btnFollowJordan = findViewById(R.id.btnFollowJordan)
        btnFollowThando = findViewById(R.id.btnFollowThando)

        updateFollowButtons()

        btnFollowAlex.setOnClickListener {
            followingAlex = !followingAlex
            updateFollowButtons()

            if (followingAlex) {
                showMessage("You're now following Alex 🔥")
            } else {
                showMessage("Unfollowed Alex")
            }
        }

        btnFollowSarah.setOnClickListener {
            followingSarah = !followingSarah
            updateFollowButtons()

            if (followingSarah) {
                showMessage("You're now following Sarah 🔥")
            } else {
                showMessage("Unfollowed Sarah")
            }
        }

        btnFollowJordan.setOnClickListener {
            followingJordan = !followingJordan
            updateFollowButtons()

            if (followingJordan) {
                showMessage("You're now following Jordan 🔥")
            } else {
                showMessage("Unfollowed Jordan")
            }
        }

        btnFollowThando.setOnClickListener {
            followingThando = !followingThando
            updateFollowButtons()

            if (followingThando) {
                showMessage("You're now following Thando 🔥")
            } else {
                showMessage("Unfollowed Thando")
            }
        }

        // =====================================================
        // ATHLETE PROFILES
        // =====================================================

        findViewById<TextView>(R.id.btnAlexProfile).setOnClickListener {
            showMessage("Alex's athlete profile")
        }

        findViewById<TextView>(R.id.btnSarahProfile).setOnClickListener {
            showMessage("Sarah's athlete profile")
        }

        findViewById<TextView>(R.id.btnJordanProfile).setOnClickListener {
            showMessage("Jordan's athlete profile")
        }

        findViewById<TextView>(R.id.btnThandoProfile).setOnClickListener {
            showMessage("Thando's athlete profile")
        }

        // =====================================================
        // VIEW FOLLOWING FEED
        // =====================================================

        findViewById<TextView>(R.id.btnViewFollowing).setOnClickListener {

            startActivity(
                Intent(
                    this,
                    FollowingActivity::class.java
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

    private fun updateFollowButtons() {

        setFollowState(btnFollowAlex, followingAlex)
        setFollowState(btnFollowSarah, followingSarah)
        setFollowState(btnFollowJordan, followingJordan)
        setFollowState(btnFollowThando, followingThando)
    }

    private fun setFollowState(button: TextView, following: Boolean) {

        if (following) {
            button.text = "FOLLOWING"
            button.setBackgroundResource(R.drawable.bg_following_button_active)
            button.setTextColor(
                getColor(android.R.color.white)
            )
        } else {
            button.text = "FOLLOW"
            button.setBackgroundResource(R.drawable.bg_follow_button)
            button.setTextColor(
                getColor(android.R.color.white)
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