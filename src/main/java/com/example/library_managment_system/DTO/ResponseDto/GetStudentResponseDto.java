package com.example.library_managment_system.DTO.ResponseDto;

import com.example.library_managment_system.entity.Card;
import com.example.library_managment_system.entity.Student;
import com.example.library_managment_system.enums.Department;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetStudentResponseDto {

    int id;
    String name;
    int age;
    Department department;
    String mobNo;
    GetCardResponseDto cardDetails;


}
