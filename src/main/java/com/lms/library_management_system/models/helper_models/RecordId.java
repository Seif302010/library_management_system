package com.lms.library_management_system.models.helper_models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Embeddable
@Data
public class RecordId implements Serializable {

    @Column(name = "book_id")
    public int bookId;

    @Column(name = "patron_id")
    public int patronId;

    @Column(name = "borrowing_date")
    public LocalDateTime borrowing_date;
}