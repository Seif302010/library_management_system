package com.lms.library_management_system.models.database_models;

import java.time.LocalDateTime;

import com.lms.library_management_system.models.helper_models.RecordId;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "BorrowingRecord")
public class BorrowingRecord {

    @EmbeddedId
    public RecordId id = new RecordId();

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id", nullable = false)
    public Book book;

    @ManyToOne
    @MapsId("patronId")
    @JoinColumn(name = "patron_id", nullable = false)
    public Patron patron;

    @Column(name = "borrowing_date", nullable = false, insertable = false, updatable = false)
    public LocalDateTime borrowing_date;

    @Column(name = "return_date")
    public LocalDateTime return_date;

    @PrePersist
    protected void onCreate() {
        this.borrowing_date = LocalDateTime.now();
        this.id.borrowing_date = this.borrowing_date;
    }
}
