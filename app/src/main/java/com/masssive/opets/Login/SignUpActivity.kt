package com.masssive.opets.Login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.masssive.opets.MainActivity
import com.masssive.opets.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Set pesan kesalahan ke null setelah teks berubah
                binding.etnama.error = null
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Tidak digunakan
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Tidak digunakan
            }
        })

        // Inisialisasi FirebaseAuth
        auth = FirebaseAuth.getInstance()

        binding.btnSignUp.setOnClickListener {
            // Memanggil fungsi untuk melakukan pendaftaran
            signUpWithEmailAndPassword()
        }
    }

    private fun signUpWithEmailAndPassword() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        // Memeriksa apakah email dan password tidak kosong
        if (email.isEmpty()) {
            Toast.makeText(this, "Email harus diisi", Toast.LENGTH_SHORT).show()
            return
        }
        if (password.isEmpty()) {
            Toast.makeText(this, "Password harus diisi", Toast.LENGTH_SHORT).show()
            return
        }
        // Membuat user baru dengan email dan password
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Pendaftaran berhasil, pindah ke MainActivity atau aktivitas lainnya
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Jika pendaftaran gagal, tampilkan pesan error
                    Toast.makeText(this, "Pendaftaran gagal: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
