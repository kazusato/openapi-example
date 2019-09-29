package kazusato.example.dto

data class BookInfo(
    var id: Int? = null,
    var title: String? = null,
    var author: String? = null,
    var publishedYear: Int? = null,
    var publisher: String? = null
)