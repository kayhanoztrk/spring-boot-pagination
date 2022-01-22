package com.springpagination.springbootpagination.service;

import com.springpagination.springbootpagination.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    //will be used for pagination process.
    Page<Book> findAll(Pageable pageable);

    Book findById(Long id);

    Book save(Book book);
    Book update(Book book);
    void delete(Long bookId);
    Book findByTitle(String titleName);
}
