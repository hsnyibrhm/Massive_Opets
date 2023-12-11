package com.masssive.opets.Login


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.masssive.opets.MainActivity
import com.masssive.opets.MyPreference
import com.masssive.opets.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var myPreference: MyPreference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myPreference = MyPreference(this)
        auth = FirebaseAuth.getInstance()

        val loginCount = myPreference.getLoginCount()

        if (loginCount > 5) {
            // Misalnya, tambahkan tindakan jika pengguna telah login lebih dari 5 kali
        }

        setupAction()
    }

    private fun setupAction() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan password harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Melakukan proses login menggunakan Firebase Authentication
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Login berhasil, pindah ke MainActivity atau aktivitas lainnya
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // Jika login gagal, tampilkan pesan error
                        Toast.makeText(this, "Login gagal: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        binding.tvSignUP.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.tvforgot.setOnClickListener {
            // Tambahkan tindakan untuk memulihkan kata sandi jika diperlukan
        }
    }
}

