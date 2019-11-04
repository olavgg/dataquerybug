package com.example


import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class BookServiceSpec extends Specification implements ServiceUnitTest<IBookService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
