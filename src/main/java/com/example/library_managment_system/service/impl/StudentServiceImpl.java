package com.example.library_managment_system.service.impl;

import com.example.library_managment_system.DTO.RequestDto.StudentRequestDto;
import com.example.library_managment_system.DTO.RequestDto.UpdateStudentMobNoRequestDto;
import com.example.library_managment_system.DTO.ResponseDto.GetCardResponseDto;
import com.example.library_managment_system.DTO.ResponseDto.GetStudentResponseDto;
import com.example.library_managment_system.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.library_managment_system.entity.Card;
import com.example.library_managment_system.entity.Student;
import com.example.library_managment_system.enums.CardStatus;
import com.example.library_managment_system.exceptions.StudentNotFoundException;
import com.example.library_managment_system.repository.StudentRepository;
import com.example.library_managment_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addstudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
//      method to get expiry date
        card.setValidTill(validTill(card));
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);
        return "Student Added Successfully...";
    }

    @Override
    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobNoRequestDto updateStudentMobNoRequestDto) throws StudentNotFoundException {

        try{
            Student student = studentRepository.findById(updateStudentMobNoRequestDto.getId()).get();
            student.setMobNo(updateStudentMobNoRequestDto.getMobNo());
            Student updatedStudent = studentRepository.save(student);

//          prepare response dto
            UpdateStudentMobNoResponseDto updateStudentMobNoResponseDto = new UpdateStudentMobNoResponseDto();
            updateStudentMobNoResponseDto.setMobNo(updatedStudent.getMobNo());
            updateStudentMobNoResponseDto.setName(updatedStudent.getName());

            return updateStudentMobNoResponseDto;

        } catch(Exception e){
            throw new StudentNotFoundException("Invalid Student Id");
        }
    }

    @Override
    public GetStudentResponseDto getStudent(int id) throws StudentNotFoundException {
        try {
            Student student = studentRepository.findById(id).get();

//            set response dto
            GetStudentResponseDto getStudentResponseDto = new GetStudentResponseDto();
            getStudentResponseDto.setName(student.getName());
            getStudentResponseDto.setAge(student.getAge());
            getStudentResponseDto.setId(student.getId());
            getStudentResponseDto.setMobNo(student.getMobNo());
            getStudentResponseDto.setDepartment(student.getDepartment());

            GetCardResponseDto getCardResponsedto = new GetCardResponseDto();
            getCardResponsedto.setCardStatus(student.getCard().getCardStatus());
            getCardResponsedto.setId(student.getCard().getId());
            getCardResponsedto.setValidTill(student.getCard().getValidTill());
            getCardResponsedto.setIssueDate(student.getCard().getIssueDate());
            getCardResponsedto.setUpdatedOn(student.getCard().getUpdatedOn());

            getStudentResponseDto.setCardDetails(getCardResponsedto);

            return getStudentResponseDto;


        } catch (Exception e){
            throw new StudentNotFoundException("Invalid Student Id");
        }
    }

//method is related to addstudent
    private Date validTill(Card card) {
//      Getting current time as card will issue for this time
        Calendar calendar = Calendar.getInstance();
//      add the expry date i.e. card is valid for 3 years
        calendar.add(Calendar.YEAR,3);
//      return the  expirys date
        return calendar.getTime();
    }
}
