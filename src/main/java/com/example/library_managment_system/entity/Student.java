package com.example.library_managment_system.entity;

import com.example.library_managment_system.enums.Department;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.repository.query.parser.Part;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;

    @Enumerated(EnumType.STRING)
    Department department;
    String mobNo;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    Card card;

}
