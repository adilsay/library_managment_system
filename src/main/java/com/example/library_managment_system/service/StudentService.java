package com.example.library_managment_system.service;

import com.example.library_managment_system.DTO.RequestDto.StudentRequestDto;
import com.example.library_managment_system.DTO.RequestDto.UpdateStudentMobNoRequestDto;
import com.example.library_managment_system.DTO.ResponseDto.GetStudentResponseDto;
import com.example.library_managment_system.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.library_managment_system.entity.Student;
import com.example.library_managment_system.exceptions.StudentNotFoundException;
import org.springframework.web.bind.annotation.RequestParam;

public interface StudentService {

    public String addstudent(StudentRequestDto studentRequestDto);

    public UpdateStudentMobNoResponseDto updateMobNo(
            UpdateStudentMobNoRequestDto updateStudentMobNoRequestDto) throws StudentNotFoundException;

    public GetStudentResponseDto getStudent(int id) throws StudentNotFoundException;

}
