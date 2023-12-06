package com.masssive.opets.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masssive.opets.MainActivity
import com.masssive.opets.MyPreference
import com.masssive.opets.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(){
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myPreference = MyPreference(this)
        var LoginCount = myPreference.getLoginCount()
        LoginCount++
        myPreference.setLoginCount(LoginCount)

        setupAction()
    }

    private fun setupAction() {
        binding.btnLogin.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.tvsignup.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }


}