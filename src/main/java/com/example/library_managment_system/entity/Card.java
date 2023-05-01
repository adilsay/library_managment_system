package com.example.library_managment_system.entity;

import com.example.library_managment_system.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @CreationTimestamp
    Date issueDate;
    @UpdateTimestamp
    Date updatedOn;
    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;
    Date validTill;
    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany (mappedBy = "card", cascade = CascadeType.ALL)
    List<Book> bookIssued = new ArrayList<>();

    @OneToMany (mappedBy = "card", cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();
}
