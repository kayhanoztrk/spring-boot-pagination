package com.springpagination.springbootpagination.api;

import com.springpagination.springbootpagination.model.Book;
import com.springpagination.springbootpagination.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
*  @author Kayhan Öztürk
*  @version 0.1
*  @since 0.1
*
 */

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Page<Book> pagination(@RequestParam Integer page,
                                 @RequestParam Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookService.findAll(pageable);
    }

    @GetMapping("/pagination")
    public Page<Book> pagination(Pageable pageable) {
        return bookService.findAll(pageable);
    }
}
