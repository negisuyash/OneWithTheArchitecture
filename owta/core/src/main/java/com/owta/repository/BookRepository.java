package com.owta.repository;

import com.owta.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
}
