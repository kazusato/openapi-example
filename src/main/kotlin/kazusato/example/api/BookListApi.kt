package kazusato.example.api

import kazusato.example.bookmanager.BookManager
import kazusato.example.dto.BookList
import javax.inject.Inject
import javax.inject.Singleton
import javax.ws.rs.GET
import javax.ws.rs.Path

@Singleton
@Path("/booklist")
class BookListApi {

    @Inject
    private lateinit var bookManager : BookManager

    @GET
    fun getBookList(): BookList {
        val bookList = bookManager.getBookList()
        return bookList
    }

}