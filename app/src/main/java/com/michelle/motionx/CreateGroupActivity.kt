package com.michelle.motionx

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateGroupActivity : AppCompatActivity() {

    private lateinit var etGroupName: EditText
    private lateinit var etDescription: EditText
    private lateinit var etLocation: EditText

    private lateinit var btnRunning: TextView
    private lateinit var btnWalking: TextView
    private lateinit var btnCycling: TextView
    private lateinit var btnGym: TextView
    private lateinit var btnHybrid: TextView

    private lateinit var btnPublic: TextView
    private lateinit var btnPrivate: TextView

    private lateinit var iconRun: TextView
    private lateinit var iconCycle: TextView
    private lateinit var iconStrength: TextView
    private lateinit var iconFire: TextView
    private lateinit var iconBolt: TextView

    private var selectedCategory = "Running"
    private var selectedPrivacy = "Public"
    private var selectedIcon = "🏃"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_group)

        setupViews()
        setupCategoryButtons()
        setupPrivacyButtons()
        setupIconButtons()
        setupActions()

        updateCategoryButtons()
        updatePrivacyButtons()
        updateIconButtons()
    }

    private fun setupViews() {

        etGroupName =
            findViewById(R.id.etGroupName)

        etDescription =
            findViewById(R.id.etGroupDescription)

        etLocation =
            findViewById(R.id.etGroupLocation)

        btnRunning =
            findViewById(R.id.btnCategoryRunning)

        btnWalking =
            findViewById(R.id.btnCategoryWalking)

        btnCycling =
            findViewById(R.id.btnCategoryCycling)

        btnGym =
            findViewById(R.id.btnCategoryGym)

        btnHybrid =
            findViewById(R.id.btnCategoryHybrid)

        btnPublic =
            findViewById(R.id.btnPublic)

        btnPrivate =
            findViewById(R.id.btnPrivate)

        iconRun =
            findViewById(R.id.iconRun)

        iconCycle =
            findViewById(R.id.iconCycle)

        iconStrength =
            findViewById(R.id.iconStrength)

        iconFire =
            findViewById(R.id.iconFire)

        iconBolt =
            findViewById(R.id.iconBolt)
    }

    private fun setupCategoryButtons() {

        btnRunning.setOnClickListener {
            selectedCategory = "Running"
            updateCategoryButtons()
        }

        btnWalking.setOnClickListener {
            selectedCategory = "Walking"
            updateCategoryButtons()
        }

        btnCycling.setOnClickListener {
            selectedCategory = "Cycling"
            updateCategoryButtons()
        }

        btnGym.setOnClickListener {
            selectedCategory = "Gym"
            updateCategoryButtons()
        }

        btnHybrid.setOnClickListener {
            selectedCategory = "Hybrid"
            updateCategoryButtons()
        }
    }

    private fun setupPrivacyButtons() {

        btnPublic.setOnClickListener {
            selectedPrivacy = "Public"
            updatePrivacyButtons()
        }

        btnPrivate.setOnClickListener {
            selectedPrivacy = "Private"
            updatePrivacyButtons()
        }
    }

    private fun setupIconButtons() {

        iconRun.setOnClickListener {
            selectedIcon = "🏃"
            updateIconButtons()
        }

        iconCycle.setOnClickListener {
            selectedIcon = "🚴"
            updateIconButtons()
        }

        iconStrength.setOnClickListener {
            selectedIcon = "🏋"
            updateIconButtons()
        }

        iconFire.setOnClickListener {
            selectedIcon = "🔥"
            updateIconButtons()
        }

        iconBolt.setOnClickListener {
            selectedIcon = "⚡"
            updateIconButtons()
        }
    }

    private fun setupActions() {

        findViewById<TextView>(
            R.id.btnBack
        ).setOnClickListener {
            finish()
        }

        findViewById<TextView>(
            R.id.btnCancel
        ).setOnClickListener {
            finish()
        }

        findViewById<TextView>(
            R.id.btnCreateGroup
        ).setOnClickListener {
            createGroup()
        }
    }

    private fun createGroup() {

        val groupName =
            etGroupName.text
                .toString()
                .trim()

        val description =
            etDescription.text
                .toString()
                .trim()

        val location =
            etLocation.text
                .toString()
                .trim()

        if (groupName.isEmpty()) {

            etGroupName.error =
                "Enter a group name"

            etGroupName.requestFocus()

            return
        }

        if (description.isEmpty()) {

            etDescription.error =
                "Enter a group description"

            etDescription.requestFocus()

            return
        }

        val approvalSwitch =
            findViewById<Switch>(
                R.id.switchApproval
            )

        val resultIntent =
            Intent()

        resultIntent.putExtra(
            "group_name",
            groupName
        )

        resultIntent.putExtra(
            "group_description",
            description
        )

        resultIntent.putExtra(
            "group_location",
            location
        )

        resultIntent.putExtra(
            "group_category",
            selectedCategory
        )

        resultIntent.putExtra(
            "group_privacy",
            selectedPrivacy
        )

        resultIntent.putExtra(
            "group_icon",
            selectedIcon
        )

        resultIntent.putExtra(
            "group_approval",
            approvalSwitch.isChecked
        )

        setResult(
            RESULT_OK,
            resultIntent
        )

        Toast.makeText(
            this,
            "$groupName created 🔥",
            Toast.LENGTH_SHORT
        ).show()

        finish()
    }

    private fun updateCategoryButtons() {

        val buttons =
            listOf(
                btnRunning,
                btnWalking,
                btnCycling,
                btnGym,
                btnHybrid
            )

        buttons.forEach {

            it.setBackgroundResource(
                R.drawable.bg_create_group_option
            )

            it.setTextColor(
                getColor(
                    R.color.create_group_inactive
                )
            )
        }

        val selectedButton =
            when (selectedCategory) {

                "Walking" ->
                    btnWalking

                "Cycling" ->
                    btnCycling

                "Gym" ->
                    btnGym

                "Hybrid" ->
                    btnHybrid

                else ->
                    btnRunning
            }

        selectedButton.setBackgroundResource(
            R.drawable.bg_create_group_option_selected
        )

        selectedButton.setTextColor(
            getColor(
                android.R.color.white
            )
        )
    }

    private fun updatePrivacyButtons() {

        btnPublic.setBackgroundResource(
            R.drawable.bg_create_group_option
        )

        btnPrivate.setBackgroundResource(
            R.drawable.bg_create_group_option
        )

        btnPublic.setTextColor(
            getColor(
                R.color.create_group_inactive
            )
        )

        btnPrivate.setTextColor(
            getColor(
                R.color.create_group_inactive
            )
        )

        val selectedButton =
            if (selectedPrivacy == "Private") {
                btnPrivate
            } else {
                btnPublic
            }

        selectedButton.setBackgroundResource(
            R.drawable.bg_create_group_option_selected
        )

        selectedButton.setTextColor(
            getColor(
                android.R.color.white
            )
        )
    }

    private fun updateIconButtons() {

        val icons =
            listOf(
                iconRun,
                iconCycle,
                iconStrength,
                iconFire,
                iconBolt
            )

        icons.forEach {

            it.setBackgroundResource(
                R.drawable.bg_create_group_icon
            )
        }

        val selected =
            when (selectedIcon) {

                "🚴" ->
                    iconCycle

                "🏋" ->
                    iconStrength

                "🔥" ->
                    iconFire

                "⚡" ->
                    iconBolt

                else ->
                    iconRun
            }

        selected.setBackgroundResource(
            R.drawable.bg_create_group_icon_selected
        )
    }
}