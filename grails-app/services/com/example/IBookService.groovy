package com.example

interface IBookService {

    List<Book> findAllByTitleAndAuthorIsNotNullOrReleaseYearIsNotNull(String title)
    List<Book> findWhereAuthorIsNotNullOrReleaseYearIsNotNull()

}
