package com.lms.library_management_system.models.database_models;

import com.lms.library_management_system.models.helper_models.BaseModel;

import jakarta.persistence.*;

@Entity
@Table(name = "Patrons")
public class Patron extends BaseModel {

    @Column(name = "name", nullable = false, unique = true)
    public String name;

    @Column(name = "email", nullable = false, unique = true)
    public String email;

    @Column(name = "phone_number", nullable = false, unique = true, length = 20)
    public String phone_number;
}
