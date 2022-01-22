package com.springpagination.springbootpagination.service.impl;

import com.springpagination.springbootpagination.exception.BookNotFoundException;
import com.springpagination.springbootpagination.model.Book;
import com.springpagination.springbootpagination.repository.BookRepository;
import com.springpagination.springbootpagination.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        Optional<Book> result = bookRepository.findById(id);

        Book book = null;
        if (result.isPresent()) {
            book = result.get();
        } else {
            throw new BookNotFoundException("Did not find book by Id : " + id);
        }
        return book;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book findByTitle(String titleName) {
        return bookRepository.findByTitle(titleName);
    }
}
