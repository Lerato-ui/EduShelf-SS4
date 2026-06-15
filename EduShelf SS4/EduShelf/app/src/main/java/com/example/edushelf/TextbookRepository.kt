package com.example.edushelf

object TextbookRepository {

    private val _books = mutableListOf(
        Textbook(1, "Calculus: Early Transcendentals", "James Stewart",
            "MAT101", "8th", 350.0, "Good",
            "Aisha Dlamini", "aisha@campus.ac.za", "071 000 0001",
            "A well-used but complete copy. Suitable for first-year maths."),
        Textbook(2, "Introduction to Algorithms", "Cormen et al.",
            "CSC201", "3rd", 480.0, "Like New",
            "Sipho Mokoena", "sipho@campus.ac.za", "072 000 0002",
            "Barely used. No highlighting or annotations."),
        Textbook(3, "Principles of Economics", "N. Gregory Mankiw",
            "ECO101", "7th", 290.0, "Fair",
            "Lerato Nkosi", "lerato@campus.ac.za", "073 000 0003",
            "Some highlighting. All pages intact."),
        Textbook(4, "Organic Chemistry", "Paula Bruice",
            "CHM202", "8th", 520.0, "New",
            "Thabo Sithole", "thabo@campus.ac.za", "074 000 0004",
            "Sealed, never used. Bought by mistake."),
        Textbook(5, "Financial Accounting", "Weygandt et al.",
            "ACC101", "3rd SA Ed", 310.0, "Good",
            "Zanele Khumalo", "zanele@campus.ac.za", "075 000 0005",
            "Minor wear on the cover. Complete and readable.")
    )

    fun getAll(): List<Textbook> = _books.toList()

    fun findById(id: Int): Textbook? = _books.find { it.id == id }

    fun search(query: String): List<Textbook> {
        if (query.isBlank()) return getAll()
        val q = query.lowercase()
        return _books.filter {
            it.title.lowercase().contains(q) ||
            it.author.lowercase().contains(q) ||
            it.course.lowercase().contains(q)
        }
    }

    fun filterByCondition(condition: String): List<Textbook> {
        if (condition == "All") return getAll()
        return _books.filter { it.condition == condition }
    }

    fun addListing(book: Textbook) { _books.add(book) }
}