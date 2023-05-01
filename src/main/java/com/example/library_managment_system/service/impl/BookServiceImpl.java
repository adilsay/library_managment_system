package com.example.library_managment_system.service.impl;

import com.example.library_managment_system.entity.Author;
import com.example.library_managment_system.entity.Book;
import com.example.library_managment_system.repository.AuthorRepository;
import com.example.library_managment_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
   @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(Book book) throws Exception {
        Author author;

        try {
            author = authorRepository.findById(book.getAuthor().getId()).get();
            author.getBooks().add(book);
            book.setAuthor(author);
            authorRepository.save(author);
        }
        catch (Exception e){
            throw new Exception("Author Not Present");
        }
        return "Book Added...";

    }
}
