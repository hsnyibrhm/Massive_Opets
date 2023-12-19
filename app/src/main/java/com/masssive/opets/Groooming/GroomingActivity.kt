package com.masssive.opets.Groooming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masssive.opets.R
import com.masssive.opets.databinding.ActivityGroomingBinding
import com.masssive.opets.databinding.ActivityLoginBinding

class GroomingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGroomingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroomingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {

        binding.groKutu.setOnClickListener{
            val intent = Intent(this, GroomingKutuActivity::class.java)
            startActivity(intent)
        }
    }

}