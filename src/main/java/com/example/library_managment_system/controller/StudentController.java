package com.example.library_managment_system.controller;

import com.example.library_managment_system.DTO.RequestDto.StudentRequestDto;
import com.example.library_managment_system.DTO.RequestDto.UpdateStudentMobNoRequestDto;
import com.example.library_managment_system.DTO.ResponseDto.GetStudentResponseDto;
import com.example.library_managment_system.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.library_managment_system.entity.Student;
import com.example.library_managment_system.exceptions.StudentNotFoundException;
import com.example.library_managment_system.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentServiceimpl;
    @PostMapping("/add")
    public String addstudent(@RequestBody StudentRequestDto studentRequestDto){

        return studentServiceimpl.addstudent(studentRequestDto);
    }
    @PutMapping("/update_mobno")
    public UpdateStudentMobNoResponseDto updateMobNo(
            @RequestBody UpdateStudentMobNoRequestDto updateStudentMobNoRequestDto)
            throws StudentNotFoundException {
//geting respons as string
        return studentServiceimpl.updateMobNo(updateStudentMobNoRequestDto);
    }

//    get student by id
    @GetMapping("/get_student")
    public GetStudentResponseDto getStudent(
            @RequestParam("id") int id) throws StudentNotFoundException {
//getting response as response dto
        return studentServiceimpl.getStudent(id);
    }
}
