package com.michelle.motionx

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LeaderboardActivity : AppCompatActivity() {

    private lateinit var leaderboardAdapter: LeaderboardAdapter

    private lateinit var tabWeek: TextView
    private lateinit var tabMonth: TextView
    private lateinit var tabAllTime: TextView

    private lateinit var txtFirstDistance: TextView
    private lateinit var txtFirstActivities: TextView
    private lateinit var txtFirstXp: TextView

    private lateinit var txtSecondDistance: TextView
    private lateinit var txtSecondActivities: TextView
    private lateinit var txtSecondXp: TextView

    private lateinit var txtThirdDistance: TextView
    private lateinit var txtThirdActivities: TextView
    private lateinit var txtThirdXp: TextView

    private lateinit var txtMyDistance: TextView
    private lateinit var txtMyXp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_leaderboard
        )

        setupViews()

        setupRecyclerView()

        setupTabs()

        setupButtons()

        loadWeeklyLeaderboard()
    }

    private fun setupViews() {

        tabWeek =
            findViewById(R.id.tabWeek)

        tabMonth =
            findViewById(R.id.tabMonth)

        tabAllTime =
            findViewById(R.id.tabAllTime)

        txtFirstDistance =
            findViewById(R.id.txtFirstDistance)

        txtFirstActivities =
            findViewById(R.id.txtFirstActivities)

        txtFirstXp =
            findViewById(R.id.txtFirstXp)

        txtSecondDistance =
            findViewById(R.id.txtSecondDistance)

        txtSecondActivities =
            findViewById(R.id.txtSecondActivities)

        txtSecondXp =
            findViewById(R.id.txtSecondXp)

        txtThirdDistance =
            findViewById(R.id.txtThirdDistance)

        txtThirdActivities =
            findViewById(R.id.txtThirdActivities)

        txtThirdXp =
            findViewById(R.id.txtThirdXp)

        txtMyDistance =
            findViewById(R.id.txtMyDistance)

        txtMyXp =
            findViewById(R.id.txtMyXp)
    }

    private fun setupRecyclerView() {

        val recyclerView =
            findViewById<RecyclerView>(
                R.id.recyclerLeaderboard
            )

        leaderboardAdapter =
            LeaderboardAdapter(
                getWeeklyAthletes().toMutableList()
            ) { athlete ->

                Toast.makeText(
                    this,
                    "${athlete.name}'s MotionX profile",
                    Toast.LENGTH_SHORT
                ).show()
            }

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        recyclerView.adapter =
            leaderboardAdapter

        recyclerView.isNestedScrollingEnabled =
            false
    }

    private fun setupTabs() {

        tabWeek.setOnClickListener {
            loadWeeklyLeaderboard()
        }

        tabMonth.setOnClickListener {
            loadMonthlyLeaderboard()
        }

        tabAllTime.setOnClickListener {
            loadAllTimeLeaderboard()
        }
    }

    private fun setupButtons() {

        findViewById<TextView>(
            R.id.btnBack
        ).setOnClickListener {
            finish()
        }

        findViewById<TextView>(
            R.id.btnAthleteFilter
        ).setOnClickListener {

            showMessage(
                "Athlete filters coming soon 🔥"
            )
        }

        findViewById<TextView>(
            R.id.btnKeepGoing
        ).setOnClickListener {

            showMessage(
                "42.8 km this week — keep moving 🔥"
            )
        }

        // =====================================================
        // BOTTOM NAVIGATION
        // =====================================================

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

            val intent =
                Intent(
                    this,
                    CommunityActivity::class.java
                )

            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_SINGLE_TOP

            startActivity(intent)

            finish()
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

    // =========================================================
    // WEEK
    // =========================================================

    private fun loadWeeklyLeaderboard() {

        selectTab(
            tabWeek
        )

        txtFirstDistance.text =
            "284.6 km"

        txtFirstActivities.text =
            "42 activities"

        txtFirstXp.text =
            "🔥 4.2K XP"

        txtSecondDistance.text =
            "241.3 km"

        txtSecondActivities.text =
            "36 activities"

        txtSecondXp.text =
            "🔥 3.8K XP"

        txtThirdDistance.text =
            "198.7 km"

        txtThirdActivities.text =
            "29 activities"

        txtThirdXp.text =
            "🔥 3.1K XP"

        txtMyDistance.text =
            "42.8 km  •  6 activities"

        txtMyXp.text =
            "🔥 820 XP"

        leaderboardAdapter.updateData(
            getWeeklyAthletes()
        )
    }

    // =========================================================
    // MONTH
    // =========================================================

    private fun loadMonthlyLeaderboard() {

        selectTab(
            tabMonth
        )

        txtFirstDistance.text =
            "864.2 km"

        txtFirstActivities.text =
            "68 activities"

        txtFirstXp.text =
            "🔥 12.8K XP"

        txtSecondDistance.text =
            "792.6 km"

        txtSecondActivities.text =
            "61 activities"

        txtSecondXp.text =
            "🔥 11.9K XP"

        txtThirdDistance.text =
            "711.4 km"

        txtThirdActivities.text =
            "57 activities"

        txtThirdXp.text =
            "🔥 10.6K XP"

        txtMyDistance.text =
            "168.4 km  •  22 activities"

        txtMyXp.text =
            "🔥 3.4K XP"

        leaderboardAdapter.updateData(
            getMonthlyAthletes()
        )
    }

    // =========================================================
    // ALL TIME
    // =========================================================

    private fun loadAllTimeLeaderboard() {

        selectTab(
            tabAllTime
        )

        txtFirstDistance.text =
            "8,942 km"

        txtFirstActivities.text =
            "742 activities"

        txtFirstXp.text =
            "🔥 128K XP"

        txtSecondDistance.text =
            "8,214 km"

        txtSecondActivities.text =
            "689 activities"

        txtSecondXp.text =
            "🔥 116K XP"

        txtThirdDistance.text =
            "7,689 km"

        txtThirdActivities.text =
            "631 activities"

        txtThirdXp.text =
            "🔥 108K XP"

        txtMyDistance.text =
            "1,284 km  •  164 activities"

        txtMyXp.text =
            "🔥 24.8K XP"

        leaderboardAdapter.updateData(
            getAllTimeAthletes()
        )
    }

    private fun selectTab(
        selectedTab: TextView
    ) {

        val tabs =
            listOf(
                tabWeek,
                tabMonth,
                tabAllTime
            )

        tabs.forEach {

            it.setBackgroundResource(
                android.R.color.transparent
            )

            it.setTextColor(
                getColor(
                    R.color.leaderboard_tab_inactive
                )
            )
        }

        selectedTab.setBackgroundResource(
            R.drawable.bg_leaderboard_tab_selected
        )

        selectedTab.setTextColor(
            getColor(
                android.R.color.white
            )
        )
    }

    // =========================================================
    // DEMO DATA
    // =========================================================

    private fun getWeeklyAthletes():
            List<AthleteRanking> {

        return listOf(

            AthleteRanking(
                4,
                "JT",
                "Jordan T.",
                172.4,
                24,
                2900
            ),

            AthleteRanking(
                5,
                "LK",
                "Liam K.",
                161.2,
                22,
                2400
            ),

            AthleteRanking(
                6,
                "ER",
                "Emma R.",
                149.6,
                20,
                2100,
                true
            ),

            AthleteRanking(
                7,
                "ZM",
                "Zara M.",
                138.9,
                18,
                1800
            ),

            AthleteRanking(
                8,
                "DS",
                "Daniel S.",
                129.7,
                17,
                1690
            ),

            AthleteRanking(
                9,
                "KM",
                "Kyle M.",
                118.9,
                15,
                1540
            )
        )
    }

    private fun getMonthlyAthletes():
            List<AthleteRanking> {

        return listOf(

            AthleteRanking(
                4,
                "JT",
                "Jordan T.",
                642.7,
                51,
                9400
            ),

            AthleteRanking(
                5,
                "ER",
                "Emma R.",
                601.8,
                49,
                8900,
                true
            ),

            AthleteRanking(
                6,
                "LK",
                "Liam K.",
                584.3,
                47,
                8500
            ),

            AthleteRanking(
                7,
                "ZM",
                "Zara M.",
                552.1,
                43,
                7900
            ),

            AthleteRanking(
                8,
                "DS",
                "Daniel S.",
                519.8,
                41,
                7500
            ),

            AthleteRanking(
                9,
                "KM",
                "Kyle M.",
                491.6,
                39,
                7100
            )
        )
    }

    private fun getAllTimeAthletes():
            List<AthleteRanking> {

        return listOf(

            AthleteRanking(
                4,
                "ER",
                "Emma R.",
                7214.5,
                598,
                101400,
                true
            ),

            AthleteRanking(
                5,
                "JT",
                "Jordan T.",
                6988.1,
                571,
                97800
            ),

            AthleteRanking(
                6,
                "LK",
                "Liam K.",
                6612.9,
                544,
                92600
            ),

            AthleteRanking(
                7,
                "ZM",
                "Zara M.",
                6241.7,
                511,
                87400
            ),

            AthleteRanking(
                8,
                "DS",
                "Daniel S.",
                5897.3,
                486,
                82100
            ),

            AthleteRanking(
                9,
                "KM",
                "Kyle M.",
                5482.6,
                451,
                77600
            )
        )
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