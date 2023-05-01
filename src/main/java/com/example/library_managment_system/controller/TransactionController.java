package com.example.library_managment_system.controller;

import com.example.library_managment_system.DTO.RequestDto.IssueBookRequestDto;
import com.example.library_managment_system.DTO.ResponseDto.IssueBookResponseDto;
import com.example.library_managment_system.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionServiceImpl transactionService;

//    api to issue the book
    @PostMapping("/issueBook")
    public IssueBookResponseDto issueBook(
            @RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {

        return transactionService.issueBook(issueBookRequestDto);
    }
}
