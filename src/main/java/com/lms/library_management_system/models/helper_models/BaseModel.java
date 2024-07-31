package com.lms.library_management_system.models.helper_models;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public int id;

    @Column(name = "added_at", nullable = false, updatable = false)
    public LocalDateTime added_at;

    @Column(name = "last_updated_at", nullable = true)
    public LocalDateTime last_updated_at;

    @PrePersist
    protected void onCreate() {
        this.added_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.last_updated_at = LocalDateTime.now();
    }
}
