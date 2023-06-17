package com.seattledevcamp.splashscreenv3

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.ProgressBar;

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.max = 100
        progressBar.progress = 0

        Thread {
            // Increment the progress bar for each step in the loading process
            for (i in 0 until 100) {
                Thread.sleep(10)
                progressBar.progress = i + 1
            }

            // Stop the loading process and hide the progress bar
            runOnUiThread {
                progressBar.visibility = View.GONE

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()

//        Handler(Looper.getMainLooper()).postDelayed({
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }, 1000) // in milliseconds.
    }
}