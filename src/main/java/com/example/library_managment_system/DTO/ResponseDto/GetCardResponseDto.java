package com.example.library_managment_system.DTO.ResponseDto;

import com.example.library_managment_system.enums.CardStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetCardResponseDto {
    int id;

    Date issueDate;

    Date updatedOn;

    CardStatus cardStatus;
    Date validTill;
}
