package com.example.edushelf

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.edushelf.databinding.ActivitySellBinding

class SellActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySellBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySellBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = getSharedPreferences("edushelf_user", MODE_PRIVATE)

        binding.btnPostTextbook.setOnClickListener {
            val title  = binding.etTitle.text.toString().trim()
            val author = binding.etAuthor.text.toString().trim()
            val course = binding.etCourse.text.toString().trim()
            val price  = binding.etPrice.text.toString().trim()

            when {
                title.isEmpty() -> {
                    binding.etTitle.error = "Book title is required"
                    Toast.makeText(this, "Please enter the book title", Toast.LENGTH_SHORT).show()
                }
                author.isEmpty() -> {
                    binding.etAuthor.error = "Author is required"
                    Toast.makeText(this, "Please enter the author", Toast.LENGTH_SHORT).show()
                }
                course.isEmpty() -> {
                    binding.etCourse.error = "Course code is required"
                    Toast.makeText(this, "Please enter the course code", Toast.LENGTH_SHORT).show()
                }
                price.isEmpty() -> {
                    binding.etPrice.error = "Price is required"
                    Toast.makeText(this, "Please enter an asking price", Toast.LENGTH_SHORT).show()
                }
                price.toDoubleOrNull() == null || price.toDouble() <= 0 -> {
                    binding.etPrice.error = "Enter a valid price"
                    Toast.makeText(this, "Invalid price", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val sellerName  = prefs.getString("name", "Unknown") ?: "Unknown"
                    val sellerEmail = prefs.getString("email", "") ?: ""
                    val newId = TextbookRepository.getAll().size + 1
                    val newBook = Textbook(
                        id = newId, title = title, author = author,
                        course = course, edition = binding.etEdition.text.toString().trim(),
                        price = price.toDouble(), condition = "Good",
                        sellerName = sellerName, sellerEmail = sellerEmail, sellerPhone = ""
                    )
                    TextbookRepository.addListing(newBook)
                    Toast.makeText(this, "Textbook posted successfully!", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }
}