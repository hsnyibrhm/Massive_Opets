package com.masssive.opets

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import com.masssive.opets.Groooming.BookingGromingKutuActivity
import com.masssive.opets.Groooming.GroomingKutuActivity
import com.masssive.opets.Penitipan.PenitipanActivity

class detail_bayar_grooming_kutu : AppCompatActivity(), View.OnClickListener {

    // Daftar ID tombol
    private val buttonIds = listOf(
        R.id.btn_brt1, R.id.btn_brt2, R.id.btn_brt3, R.id.btn_wkt1, R.id.btn_wkt2,
        R.id.btn_wkt3, R.id.btn_wkt4, R.id.btn_wkt5, R.id.btn_wkt6,
    R.id.btn_wkt7, R.id.btn_wkt8
    )
    // Daftar tombol
    private val buttons = ArrayList<Button>()
    // variabel menentukan animasi button
    private var isButtonLinkClicked = false
    // Variabel xml khusus untuk interest
    private lateinit var btnBack: Button
    private lateinit var byrkutu: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_bayar_grooming_kutu)

        // Inisialisasi tombol
        for (buttonId in buttonIds) {
            // ambil listOf
            val button = findViewById<Button>(buttonId)
            // Menambahkan OnClickListener untuk setiap tombol
            button.setOnClickListener { toggleButtonBackground(button) }
            // Menyimpan tombol dalam daftar untuk referensi lebih lanjut
            buttons.add(button)
        }


        // Inisialisasi Xml
        btnBack = findViewById(R.id.btnBack)
        byrkutu = findViewById(R.id.byr_kutu)

        // tombol kembali(penitipan)
        val backPenitipanActivity: TextView = findViewById(R.id.btnBack)
        backPenitipanActivity.setOnClickListener(this)

        val kebayar: Button = findViewById(R.id.byr_kutu)
        kebayar.setOnClickListener(this)

        // Tombol kembali perangkat Penitipan
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Pindah ke WelcomeActivity
                val intent = Intent(this@detail_bayar_grooming_kutu, GroomingKutuActivity::class.java)
                startActivity(intent)
            }
        }
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    // Fungsi untuk mengganti latar belakang tombol
    private fun toggleButtonBackground(button: Button) {
        if (button.isSelected) {
            // Ganti warna saat pertama kali diklik
            button.setBackgroundResource(R.drawable.btn_theme_2)
            button.setTextColor(ContextCompat.getColor(this, R.color.white))
        } else {
            // Ganti warna saat diklik lagi
            button.setBackgroundResource(R.drawable.btn_detail_perawatan)
            button.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
        // Mengubah status isSelected tombol
        button.isSelected = !button.isSelected
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnBack -> {
                // Navigasi kembali ke WellcomeActivity
                val intent = Intent(this@detail_bayar_grooming_kutu, GroomingKutuActivity::class.java)
                if(!isButtonLinkClicked) {
                    btnBack.setBackgroundResource(R.drawable.back)
                    isButtonLinkClicked = true
                }
                startActivity(intent)
            }

            R.id.byr_kutu->{
                val intent = Intent(this, PembayaranQrisActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // ubah kembali
        btnBack.setBackgroundResource(R.drawable.back)
        // jadikan valse
        isButtonLinkClicked = false
    }

}