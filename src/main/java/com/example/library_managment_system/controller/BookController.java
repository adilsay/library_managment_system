package com.example.library_managment_system.controller;

import com.example.library_managment_system.entity.Book;
import com.example.library_managment_system.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceImpl bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception {

        return bookService.addBook(book);
    }
}
