package com.masssive.opets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import com.masssive.opets.booking.BookingFragment
import com.masssive.opets.chat.ChatFragment
import com.masssive.opets.databinding.ActivityMainBinding
import com.masssive.opets.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        // Set default icon color
        val defaultIconColor = ContextCompat.getColorStateList(this, R.color.oren)
        binding.bottomNavigationView.itemIconTintList = defaultIconColor

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            // Reset icon colors to default for all items
            binding.bottomNavigationView.menu.forEach { item ->
                item.icon?.setTintList(defaultIconColor)
            }

            // Set icon color for the selected item
            val selectedIconColor = ContextCompat.getColorStateList(this, R.color.oren)
            menuItem.icon?.setTintList(selectedIconColor)

            when (menuItem.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.pet -> replaceFragment(BookingFragment())
                R.id.chat -> replaceFragment(ChatFragment())
                R.id.user -> replaceFragment(ProfileFragment())
                else -> {
                    // Handle other cases if needed
                }
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
