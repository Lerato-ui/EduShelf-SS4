package com.example.edushelf

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.edushelf.databinding.ActivityBrowseBinding

class BrowseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBrowseBinding
    private val viewModel: TextbookViewModel by viewModels()
    private lateinit var adapter: TextbookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrowseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupSearch()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = TextbookAdapter(emptyList()) { book ->
            viewModel.selectBook(book)
            val intent = Intent(this, BookDetailActivity::class.java)
            intent.putExtra("BOOK_ID", book.id)
            startActivity(intent)
        }
        binding.rvTextbooks.layoutManager = LinearLayoutManager(this)
        binding.rvTextbooks.adapter = adapter
    }

    private fun setupSearch() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query.isNullOrBlank()) {
                    Toast.makeText(this@BrowseActivity,
                        "Please enter a search term", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.search(query)
                }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.search(newText ?: "")
                return true
            }
        })
    }

    private fun observeViewModel() {
        viewModel.textbooks.observe(this) { books ->
            adapter.updateList(books)
            if (books.isEmpty()) {
                Toast.makeText(this, "No textbooks found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}