package com.lms.library_management_system.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lms.library_management_system.models.database_models.Patron;

public interface PatronRepository extends JpaRepository<Patron, Integer> {
    @Query("SELECT b FROM Patron b WHERE b.name = :name")
    Optional<Patron> findByName(String name);

    @Query("SELECT b FROM Patron b WHERE b.email = :email")
    Optional<Patron> findByEmail(String email);

    @Query("SELECT b FROM Patron b WHERE b.phone_number = :phone_number")
    Optional<Patron> findByPhoneNumber(String phone_number);
}
