package com.masssive.opets.Login


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masssive.opets.MainActivity
import com.masssive.opets.MyPreference
import com.masssive.opets.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var myPreference: MyPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myPreference = MyPreference(this)

        val loginCount = myPreference.getLoginCount()

        if (loginCount > 5) {

        }

        setupAction()
    }

    private fun setupAction() {
        binding.btnLogin.setOnClickListener {

            val currentLoginCount = myPreference.getLoginCount()
            myPreference.setLoginCount(currentLoginCount + 1)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tvSignUP.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
