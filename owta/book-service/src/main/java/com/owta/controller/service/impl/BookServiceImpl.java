package com.owta.controller.service.impl;

import com.owta.controller.service.BookService;
import com.owta.model.Book;
import com.owta.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public ResponseEntity<Book> getBooking(Integer id) {
        return ResponseEntity.status(200).body(bookRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<String> deleteBooking(Integer id) {
        bookRepository.deleteById(id);
        return ResponseEntity.status(200).body("DELETED RECORD");
    }

    @Override
    public ResponseEntity<Book> updateBooking(Integer id, Book book) {
        Optional<Book> originalBook = bookRepository.findById(id);
        if(!originalBook.isPresent())
            return ResponseEntity.status(404).body(null);
        book.setId(originalBook.get().getId());
        return ResponseEntity.status(201).body(bookRepository.save(book));
    }

    @Override
    public ResponseEntity<Book> createBooking(Book book) {
        return ResponseEntity.status(201).body(bookRepository.save(book));
    }
}
