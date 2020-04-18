package com.owta.controller;

import com.owta.controller.service.BookService;
import com.owta.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/getBook/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id")Integer id){
        return bookService.getBooking(id);
    }

    @PostMapping(path = "/createBook")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return bookService.createBooking(book);
    }

    @PutMapping(path = "/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id")Integer id,@RequestBody Book book){
        return bookService.updateBooking(id,book);
    }

    @DeleteMapping(path = "/deleteBook")
    public ResponseEntity<String> deleteBook(@PathVariable("id")Integer id){
        return bookService.deleteBooking(id);
    }
}
