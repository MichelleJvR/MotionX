package com.michelle.motionx

import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var backgroundVideo: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backgroundVideo = findViewById(R.id.backgroundVideo)

        val videoUri = Uri.parse(
            "android.resource://$packageName/${R.raw.motionx_background}"
        )

        backgroundVideo.setVideoURI(videoUri)

        backgroundVideo.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
            mediaPlayer.setVolume(0f, 0f)

            backgroundVideo.start()
        }
        val btnGetStarted = findViewById<TextView>(R.id.btnGetStarted)

        btnGetStarted.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        val btnSignIn = findViewById<TextView>(R.id.btnSignIn)

        btnSignIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()

        if (::backgroundVideo.isInitialized) {
            backgroundVideo.start()
        }
    }

    override fun onPause() {
        super.onPause()

        if (::backgroundVideo.isInitialized) {
            backgroundVideo.pause()
        }
    }
}