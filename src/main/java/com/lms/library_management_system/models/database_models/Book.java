package com.lms.library_management_system.models.database_models;

import com.lms.library_management_system.models.helper_models.BaseModel;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Books")
public class Book extends BaseModel {

    @Column(name = "available_copies", nullable = false)
    @ColumnDefault("0")
    public int available_copies;

    @Column(name = "title", nullable = false, unique = true)
    @NotBlank(message = "title is required")
    public String title;

    @Column(name = "author", nullable = false)
    @NotBlank(message = "author is required")
    public String author;

    @Column(name = "publication_year", nullable = false, length = 4)
    @NotBlank(message = "publication_year is required")
    public String publication_year;

    @Column(name = "ISBN", nullable = false, unique = true, length = 20)
    @NotBlank(message = "ISBN is required")
    public String ISBN;

}
