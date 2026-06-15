package com.example.edushelf

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.edushelf.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = getSharedPreferences("edushelf_user", MODE_PRIVATE)

        binding.btnLoginSubmit.setOnClickListener {
            val name  = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val pass  = binding.etPassword.text.toString().trim()

            when {
                name.isEmpty() -> {
                    binding.etName.error = "Name is required"
                    Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                }
                email.isEmpty() -> {
                    binding.etEmail.error = "Email is required"
                    Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                }
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    binding.etEmail.error = "Enter a valid email address"
                    Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
                }
                pass.isEmpty() -> {
                    binding.etPassword.error = "Password is required"
                    Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
                }
                pass.length < 6 -> {
                    binding.etPassword.error = "Password must be at least 6 characters"
                    Toast.makeText(this, "Password too short", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    prefs.edit().putString("name", name).putString("email", email).apply()
                    startActivity(Intent(this, HomeActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    })
                }
            }
        }
    }
}