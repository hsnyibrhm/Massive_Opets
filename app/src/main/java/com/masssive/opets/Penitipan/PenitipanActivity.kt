package com.masssive.opets.Penitipan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masssive.opets.R
import com.masssive.opets.ReviewCatHotelActivity
import com.masssive.opets.databinding.ActivityPenitipanBinding
import com.masssive.opets.detail_bayar_penitipan

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
            val intent = Intent(this, detail_bayar_penitipan::class.java)
            startActivity(intent)
        }

        binding.nextpntp.setOnClickListener {
            val intent = Intent(this,ReviewCatHotelActivity::class.java)
            startActivity(intent)
        }
    }
}