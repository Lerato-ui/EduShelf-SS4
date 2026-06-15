package com.example.edushelf

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.edushelf.databinding.ActivityBookDetailBinding

class BookDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_book_detail)

        val bookId = intent.getIntExtra("BOOK_ID", -1)
        val book   = TextbookRepository.findById(bookId)

        if (book == null) {
            Toast.makeText(this, "Book not found", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        binding.textbook = book
        binding.executePendingBindings()

        binding.btnContactSeller.setOnClickListener {
            val intent = Intent(this, EnquiryActivity::class.java)
            intent.putExtra("BOOK_ID", book.id)
            startActivity(intent)
        }

        binding.btnBuy.setOnClickListener {
            Toast.makeText(
                this,
                "Contact ${book.sellerName} to complete your purchase.",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}