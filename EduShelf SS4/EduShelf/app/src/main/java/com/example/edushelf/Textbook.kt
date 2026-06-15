package com.example.edushelf

data class Textbook(
    val id: Int,
    val title: String,
    val author: String,
    val course: String,
    val edition: String = "",
    val price: Double,
    val condition: String,
    val sellerName: String,
    val sellerEmail: String,
    val sellerPhone: String,
    val description: String = ""
) {
    fun formattedPrice(): String = "R%.2f".format(price)
    fun authorCourse(): String = "$author · $course"
}