package com.masssive.opets.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.masssive.opets.LoginActivity
import com.masssive.opets.R

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIMEOUT: Long = 3000 // Waktu tampilan splash screen dalam milidetik
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val mainIntent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_TIMEOUT)
    }
}