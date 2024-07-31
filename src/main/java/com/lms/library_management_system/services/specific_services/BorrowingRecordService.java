package com.lms.library_management_system.services.specific_services;

import com.lms.library_management_system.exceptions.InvalidIdException;
import com.lms.library_management_system.models.database_models.*;
import com.lms.library_management_system.repositories.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowingRecordService {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatronRepository patronRepository;

    private void checkIds(Book book, Patron patron) {
        Map<String, String> errorMessages = new HashMap<>();

        if (book == null) {
            errorMessages.put("bookId", "Invalid book ID.");
        }
        if (patron == null) {
            errorMessages.put("patronId", "Invalid patron ID.");
        }

        if (!errorMessages.isEmpty()) {
            throw new InvalidIdException(errorMessages);
        }
    }

    public BorrowingRecord borrowBook(int bookId, int patronId) {

        Book book = bookRepository.findById(bookId)
                .orElse(null);
        Patron patron = patronRepository.findById(patronId)
                .orElse(null);
        checkIds(book, patron);

        boolean hasNotReturned = borrowingRecordRepository
                .findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId)
                .isPresent();
        if (hasNotReturned) {
            throw new IllegalStateException("The patron cannot borrow the same book until it is returned.");
        }

        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);

        return borrowingRecordRepository.save(borrowingRecord);
    }

    public BorrowingRecord returnBook(int bookId, int patronId) {
        Book book = bookRepository.findById(bookId)
                .orElse(null);
        Patron patron = patronRepository.findById(patronId)
                .orElse(null);

        checkIds(book, patron);

        BorrowingRecord borrowingRecord = borrowingRecordRepository
                .findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No active borrowing record found for the given book and patron IDs"));

        borrowingRecord.setReturn_date(LocalDateTime.now());

        return borrowingRecordRepository.save(borrowingRecord);
    }
}
