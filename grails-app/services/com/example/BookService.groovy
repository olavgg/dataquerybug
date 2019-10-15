package com.example

import grails.gorm.services.Query
import grails.gorm.services.Service

@Service(Book)
interface BookService {

    @Query("SELECT ${b.title} FROM ${Book b}")
    List<String> getTitles()

}
