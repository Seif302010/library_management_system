package com.lms.library_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lms.library_management_system.models.database_models.Patron;

public interface PatronRepository extends JpaRepository<Patron, Integer> {
}
