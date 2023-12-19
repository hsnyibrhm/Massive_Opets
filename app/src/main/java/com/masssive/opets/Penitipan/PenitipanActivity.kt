package com.masssive.opets.Penitipan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masssive.opets.R
import com.masssive.opets.databinding.ActivityPenitipanBinding

class PenitipanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPenitipanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPenitipanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.bkCathotel.setOnClickListener{
            val intent = Intent(this, BookingPenitipanActivity::class.java)
            startActivity(intent)
        }
    }
}