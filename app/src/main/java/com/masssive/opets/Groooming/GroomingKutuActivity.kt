package com.masssive.opets.Groooming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masssive.opets.R
import com.masssive.opets.ReviewGroomingActivity
import com.masssive.opets.databinding.ActivityGroomingKutuBinding
import com.masssive.opets.detail_bayar_grooming_kutu

class GroomingKutuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGroomingKutuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroomingKutuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.btnBookingGk.setOnClickListener{
            val intent = Intent(this, detail_bayar_grooming_kutu::class.java)
            startActivity(intent)
        }

        binding.nextkt.setOnClickListener{
            val intent = Intent(this, ReviewGroomingActivity ::class.java)
            startActivity(intent)
        }
    }
}