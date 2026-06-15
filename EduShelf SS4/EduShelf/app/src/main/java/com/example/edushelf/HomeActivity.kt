package com.example.edushelf

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.edushelf.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = getSharedPreferences("edushelf_user", MODE_PRIVATE)

        val name = prefs.getString("name", "Student") ?: "Student"
        binding.tvGreeting.text = "Hey there, $name"

        binding.btnGrabTextbook.setOnClickListener {
            startActivity(Intent(this, BrowseActivity::class.java))
        }
        binding.btnSell.setOnClickListener {
            startActivity(Intent(this, SellActivity::class.java))
        }
        binding.btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        binding.btnDownload.setOnClickListener {
            android.widget.Toast.makeText(
                this, "You are already using the Android app!", android.widget.Toast.LENGTH_SHORT
            ).show()
        }
    }
}