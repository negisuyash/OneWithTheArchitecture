package com.owta.controller.service;

import com.owta.model.Book;
import org.springframework.http.ResponseEntity;

public interface BookService {
    ResponseEntity<Book> getBooking(Integer id);

    ResponseEntity<String> deleteBooking(Integer id);

    ResponseEntity<Book> updateBooking(Integer id,Book book);

    ResponseEntity<Book> createBooking(Book book);
}
