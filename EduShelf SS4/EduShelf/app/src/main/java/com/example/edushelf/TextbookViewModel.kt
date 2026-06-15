package com.example.edushelf

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextbookViewModel : ViewModel() {

    private val _textbooks = MutableLiveData<List<Textbook>>()
    val textbooks: LiveData<List<Textbook>> get() = _textbooks

    private val _selected = MutableLiveData<Textbook?>()
    val selected: LiveData<Textbook?> get() = _selected

    init { loadAll() }

    fun loadAll() {
        _textbooks.value = TextbookRepository.getAll()
    }

    fun search(query: String) {
        _textbooks.value = TextbookRepository.search(query)
    }

    fun filterByCondition(condition: String) {
        _textbooks.value = TextbookRepository.filterByCondition(condition)
    }

    fun selectBook(book: Textbook) { _selected.value = book }
}