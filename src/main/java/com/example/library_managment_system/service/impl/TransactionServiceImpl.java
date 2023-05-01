package com.example.library_managment_system.service.impl;

import com.example.library_managment_system.DTO.RequestDto.IssueBookRequestDto;
import com.example.library_managment_system.DTO.ResponseDto.IssueBookResponseDto;
import com.example.library_managment_system.entity.Book;
import com.example.library_managment_system.entity.Card;
import com.example.library_managment_system.entity.Transaction;
import com.example.library_managment_system.enums.CardStatus;
import com.example.library_managment_system.enums.TransactionStatus;
import com.example.library_managment_system.repository.BookRepository;
import com.example.library_managment_system.repository.CardRepository;
import com.example.library_managment_system.repository.TransactionRepository;
import com.example.library_managment_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;

//    method to issue the book
    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        Card card;
        try{
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        } catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Card Id");
        }

        transaction.setCard(card);

        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        } catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book Id");
        }

        transaction.setBook(book);

        if(card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card Is Not Activated !!!");
        }

        if(book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book Is Alrady Issued !!!");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);

        card.getBookIssued().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card);

//        prepare response dto
        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());

        return issueBookResponseDto;
    }
}
