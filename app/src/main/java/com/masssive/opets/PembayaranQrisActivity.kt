package com.masssive.opets

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.masssive.opets.booking.BookingFragment
import com.masssive.opets.databinding.ActivityPembayaranQrisBinding

class PembayaranQrisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPembayaranQrisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPembayaranQrisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.bckqris.setOnClickListener {
           val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
