package com.example.edushelf

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.edushelf.databinding.ActivityEnquiryBinding

class EnquiryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEnquiryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnquiryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookId = intent.getIntExtra("BOOK_ID", -1)
        val book = TextbookRepository.findById(bookId)

        if (book != null) {
            binding.tvEnquiryTitle.text = "Enquire about: ${book.title}"
            binding.tvSellerName.text = "Seller: ${book.sellerName}"
        }

        binding.btnSendEnquiry.setOnClickListener {
            val name    = binding.etEnquiryName.text.toString().trim()
            val email   = binding.etEnquiryEmail.text.toString().trim()
            val message = binding.etEnquiryMessage.text.toString().trim()

            when {
                name.isEmpty() -> {
                    binding.etEnquiryName.error = "Your name is required"
                    Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                }
                email.isEmpty() -> {
                    binding.etEnquiryEmail.error = "Your email is required"
                    Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                }
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    binding.etEnquiryEmail.error = "Enter a valid email address"
                    Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
                }
                message.isEmpty() -> {
                    binding.etEnquiryMessage.error = "Message cannot be empty"
                    Toast.makeText(this, "Please write a message", Toast.LENGTH_SHORT).show()
                }
                message.length < 10 -> {
                    binding.etEnquiryMessage.error = "Message is too short"
                    Toast.makeText(this, "Please write a longer message", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(
                        this,
                        "Enquiry sent to ${book?.sellerName ?: "seller"}!",
                        Toast.LENGTH_LONG
                    ).show()
                    finish()
                }
            }
        }
    }
}