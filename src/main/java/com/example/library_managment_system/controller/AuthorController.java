package com.example.library_managment_system.controller;

import com.example.library_managment_system.entity.Author;
import com.example.library_managment_system.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){

        return authorService.addAuthor(author);
    }
}
