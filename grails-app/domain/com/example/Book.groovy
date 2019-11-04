package com.example

class Book {

    String title
    String author
    Integer releaseYear

    static constraints = {
        title nullable: false
        author nullable: true
        releaseYear nullable: true
    }
}
