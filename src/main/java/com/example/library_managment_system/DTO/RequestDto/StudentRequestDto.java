package com.example.library_managment_system.DTO.RequestDto;

import com.example.library_managment_system.enums.Department;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequestDto {
    String name;
    int age;
    Department department;
    String mobNo;

}
