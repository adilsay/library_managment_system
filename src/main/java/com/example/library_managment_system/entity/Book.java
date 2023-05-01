package com.example.library_managment_system.entity;

import com.example.library_managment_system.enums.Genre;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    @Enumerated(EnumType.STRING)
    Genre genre;
    int numberOfPages;
    int price;

    boolean isIssued = false;
    @ManyToOne
    @JoinColumn
    Author author;

    @ManyToOne
    @JoinColumn
    Card card;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();

}
