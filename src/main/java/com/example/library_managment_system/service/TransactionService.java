package com.example.library_managment_system.service;

import com.example.library_managment_system.DTO.RequestDto.IssueBookRequestDto;
import com.example.library_managment_system.DTO.ResponseDto.IssueBookResponseDto;

public interface TransactionService {
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
