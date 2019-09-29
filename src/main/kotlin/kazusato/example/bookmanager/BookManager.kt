package kazusato.example.bookmanager

import kazusato.example.dto.BookInfo
import kazusato.example.dto.BookList
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Singleton

@Singleton
open class BookManager {

    private val bookMap : ConcurrentHashMap<Int, BookInfo> = ConcurrentHashMap()

    private var lastBookId: Int = 0

    open fun registerBookInfo(bookInfo: BookInfo): BookInfo {
        checkBookInfo(bookInfo)

        var newBookInfo : BookInfo?
        synchronized(bookMap) {
            val nextBookId = lastBookId++

            newBookInfo = bookInfo.copy(id = nextBookId)
            bookMap.put(nextBookId, newBookInfo!!)
        }

        return bookInfo
    }

    private fun checkBookInfo(bookInfo: BookInfo) {
        if (bookInfo.id != null) {
            throw IllegalArgumentException("When you register a new book info, bookId should be null.")
        }
        if (bookInfo.title.isNullOrBlank()) {
            throw IllegalArgumentException("Title must not be null, empty, or blank.")
        }
        if (bookInfo.author.isNullOrBlank()) {
            throw IllegalArgumentException("Author must not be null, empty, or blank.")
        }
        if (bookInfo.publishedYear == null) {
            throw IllegalArgumentException("Published year must not be null.")
        }
        if (bookInfo.publisher.isNullOrBlank()) {
            throw IllegalArgumentException("Publisher must not be null, empty, or blank.")
        }
    }

    open fun getBookInfo(bookId: Int): BookInfo {
        if (bookMap.containsKey(bookId)) {
            return bookMap[bookId]!!
        } else {
            throw IllegalArgumentException("No such book: $bookId")
        }
    }

    open fun getBookList(): BookList {
        val bookList = BookList()
        bookList.addAll(bookMap.values.toList())

        return bookList
    }

}