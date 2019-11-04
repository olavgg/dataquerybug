package com.example

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.DependsOn
import org.springframework.stereotype.Component
/**
 * User: olav
 * Date: 01.10.2019
 * Time: 15:56
 */

@Component
@DependsOn("hibernateDatastoreServiceRegistry")
class BookJob {

    private static Logger log = LoggerFactory.getLogger(BookJob.class)

    @Autowired
    BookService bookService

    //@Scheduled(cron = "0 */1 * * * ?")
    void analyzeBooks() {

        //List<Book> bookTitles = bookService.findAllByTitleAndAuthorIsNotNullOrReleaseDateIsNotNull("Grails")
        log.debug("book count: " + bookTitles.size())

    }
}
