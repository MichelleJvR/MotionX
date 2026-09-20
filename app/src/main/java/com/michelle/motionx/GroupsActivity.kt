package com.michelle.motionx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GroupsActivity : AppCompatActivity() {

    private lateinit var groupsAdapter: MotionGroupAdapter

    private val groups =
        mutableListOf(
            MotionGroup(
                "Johannesburg Runners",
                "🏃",
                "Road runs, weekend sessions and local running motivation.",
                2847,
                "Running",
                true
            ),
            MotionGroup(
                "MotionX Girls Run Club",
                "⚡",
                "A supportive space for women who love to move.",
                1942,
                "Running",
                false
            ),
            MotionGroup(
                "Weekend Warriors",
                "🔥",
                "For athletes who make every weekend count.",
                3618,
                "Multi-Sport",
                false
            ),
            MotionGroup(
                "Pretoria Cycling Crew",
                "🚴",
                "Road cycling, endurance rides and group sessions.",
                1264,
                "Cycling",
                false
            ),
            MotionGroup(
                "5K to 10K",
                "🏁",
                "Build your speed, consistency and confidence.",
                5281,
                "Running",
                true
            ),
            MotionGroup(
                "Strength & Miles",
                "🏋",
                "Running meets strength training.",
                2179,
                "Hybrid",
                false
            )
        )

    private val createGroupLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == Activity.RESULT_OK) {

                val data =
                    result.data

                val name =
                    data?.getStringExtra(
                        "group_name"
                    ) ?: return@registerForActivityResult

                val description =
                    data.getStringExtra(
                        "group_description"
                    ) ?: ""

                val category =
                    data.getStringExtra(
                        "group_category"
                    ) ?: "Running"

                val icon =
                    data.getStringExtra(
                        "group_icon"
                    ) ?: "🏃"

                val location =
                    data.getStringExtra(
                        "group_location"
                    ) ?: ""

                val displayDescription =
                    if (location.isNotBlank()) {
                        "$description • $location"
                    } else {
                        description
                    }

                groups.add(
                    0,
                    MotionGroup(
                        name,
                        icon,
                        displayDescription,
                        1,
                        category,
                        true
                    )
                )

                groupsAdapter.notifyItemInserted(
                    0
                )

                findViewById<RecyclerView>(
                    R.id.recyclerGroups
                ).scrollToPosition(
                    0
                )

                Toast.makeText(
                    this,
                    "$name added to My Groups 🔥",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_groups
        )

        setupGroups()

        setupButtons()
    }

    private fun setupGroups() {

        val recyclerView =
            findViewById<RecyclerView>(
                R.id.recyclerGroups
            )

        groupsAdapter =
            MotionGroupAdapter(
                groups
            ) { group ->

                Toast.makeText(
                    this,
                    group.name,
                    Toast.LENGTH_SHORT
                ).show()
            }

        recyclerView.layoutManager =
            LinearLayoutManager(
                this
            )

        recyclerView.adapter =
            groupsAdapter

        recyclerView.isNestedScrollingEnabled =
            false
    }

    private fun setupButtons() {

        findViewById<TextView>(
            R.id.btnBack
        ).setOnClickListener {
            finish()
        }

        findViewById<TextView>(
            R.id.btnCreateGroup
        ).setOnClickListener {

            createGroupLauncher.launch(
                Intent(
                    this,
                    CreateGroupActivity::class.java
                )
            )
        }

        findViewById<TextView>(
            R.id.btnMyGroups
        ).setOnClickListener {

            Toast.makeText(
                this,
                "My Groups 🔥",
                Toast.LENGTH_SHORT
            ).show()
        }

        findViewById<TextView>(
            R.id.btnDiscoverGroups
        ).setOnClickListener {

            Toast.makeText(
                this,
                "Discover Groups",
                Toast.LENGTH_SHORT
            ).show()
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

            startActivity(
                intent
            )

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

            startActivity(
                intent
            )

            finish()
        }

        findViewById<TextView>(
            R.id.navAdd
        ).setOnClickListener {

            Toast.makeText(
                this,
                "Start Activity 🔥",
                Toast.LENGTH_SHORT
            ).show()
        }

        findViewById<TextView>(
            R.id.navProgress
        ).setOnClickListener {

            Toast.makeText(
                this,
                "Progress",
                Toast.LENGTH_SHORT
            ).show()
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
}