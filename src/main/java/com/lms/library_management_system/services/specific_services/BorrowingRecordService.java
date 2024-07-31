package com.lms.library_management_system.services.specific_services;

import com.lms.library_management_system.exceptions.*;
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

    @Autowired
    private BookService bookService;

    private void checkIds(Book book, Patron patron) {
        Map<String, String> errorMessages = new HashMap<>();

        if (book == null) {
            errorMessages.put("bookId", "Invalid book ID.");
        } else if (book.available_copies == 0) {
            errorMessages.put(book.title, "Not available for borrowing");
        }
        if (patron == null) {
            errorMessages.put("patronId", "Invalid patron ID.");
        }

        if (!errorMessages.isEmpty()) {
            throw new InvalidException(errorMessages);
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
            throw new ErrorMessage("The patron cannot borrow the same book until it is returned.");
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
                .orElseThrow(() -> new ErrorMessage(
                        "No active borrowing record found for the given book and patron IDs"));
        borrowingRecord.setReturn_date(LocalDateTime.now());

        return borrowingRecordRepository.save(borrowingRecord);
    }

    public void modifyAvailableCopies(int bookId, int value) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException(
                "No book found with id: " + bookId));
        if (book.available_copies < Math.abs(value) && value < 0) {
            throw new ErrorMessage("Book available copies can't be negative.");
        }
        book.available_copies += value;
        bookService.update(book.id, book);
    }
}
