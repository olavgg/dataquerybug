package dataquerybug

import com.example.Book
import com.example.BookService

class BootStrap {

    BookService bookService

    def init = { servletContext ->

        Book.withTransaction {
            new Book(title: "Grails", author: "Graeme", releaseYear: null).save(failOnError: true)
            new Book(title: "Grails", author: null, releaseYear: null).save(failOnError: true)
            new Book(title: "Grails", author: "Jeff", releaseYear: 2020).save(failOnError: true)
            new Book(title: "Grails", author: null, releaseYear: 20021).save(failOnError: true)
        }

        Book.withTransaction {
            List<Book> books1 =
                    bookService.findAllByTitleAndAuthorIsNotNullOrReleaseYearIsNotNull("Grails")
            log.debug("Total books1 found: " + books1.size())

            List<Book> books2 =
                    bookService.findWhereAuthorIsNotNullOrReleaseYearIsNotNull()
            log.debug("Total books2 found: " + books2.size())
        }
    }
    def destroy = {
    }
}
