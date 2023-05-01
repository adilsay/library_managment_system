package com.example.library_managment_system.DTO.ResponseDto;

import com.example.library_managment_system.controller.TransactionController;
import com.example.library_managment_system.enums.TransactionStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IssueBookResponseDto {
    String transactionNumber;
    TransactionStatus  transactionStatus;
    String bookName;
}
