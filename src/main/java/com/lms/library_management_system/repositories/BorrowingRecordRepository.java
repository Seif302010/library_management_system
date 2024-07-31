package com.lms.library_management_system.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lms.library_management_system.models.database_models.BorrowingRecord;
import com.lms.library_management_system.models.helper_models.RecordId;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, RecordId> {
    @Query("SELECT br FROM BorrowingRecord br WHERE br.patron.id = :patronId AND br.book.id = :bookId AND br.return_date IS NULL")
    Optional<BorrowingRecord> findByBookIdAndPatronIdAndReturnDateIsNull(int bookId, int patronId);
}
