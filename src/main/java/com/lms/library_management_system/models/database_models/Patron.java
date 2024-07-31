package com.lms.library_management_system.models.database_models;

import com.lms.library_management_system.models.helper_models.BaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Patrons")
public class Patron extends BaseModel {

    @Column(name = "name", nullable = false, unique = true)
    @NotBlank(message = "name is required")
    public String name;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "email is required")
    public String email;

    @Column(name = "phone_number", nullable = false, unique = true, length = 20)
    @NotBlank(message = "phone_number is required")
    public String phone_number;
}
