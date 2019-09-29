package kazusato.example.dto

data class BookList(
    var bookList: MutableList<BookInfo> = mutableListOf()
) {
    fun addAll(givenList: List<BookInfo>) {
        bookList.addAll(givenList)
    }
}