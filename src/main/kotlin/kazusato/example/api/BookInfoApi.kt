package kazusato.example.api

import kazusato.example.bookmanager.BookManager
import kazusato.example.dto.BookInfo
import javax.inject.Inject
import javax.inject.Singleton
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam

@Singleton
@Path("/bookinfo")
class BookInfoApi {

    @Inject
    private lateinit var bookManager : BookManager

    @GET
    @Path("/{bookId}")
    fun getBookInfo(@PathParam("bookId") bookId: Int): BookInfo {
        return bookManager.getBookInfo(bookId)
    }

    @POST
    fun registerBookInfo(bookInfo: BookInfo): BookInfo {
        val newBookInfo = bookManager.registerBookInfo(bookInfo)
        return newBookInfo
    }

}