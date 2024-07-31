package com.lms.library_management_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lms.library_management_system.models.database_models.*;
import com.lms.library_management_system.services.specific_services.BorrowingRecordService;

@RestController
@RequestMapping("/api/borrow")
public class BorrowingRecordController {
    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @PostMapping("/{bookId}/patron/{patronId}")
    public ResponseEntity<?> borrowBook(@PathVariable int bookId, @PathVariable int patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordService.borrowBook(bookId, patronId);
        borrowingRecordService.modifyAvailableCopies(bookId, -1);
        return ResponseEntity.ok(borrowingRecord);
    }

    @PutMapping("/{bookId}/patron/{patronId}")
    public ResponseEntity<?> returnBook(@PathVariable int bookId, @PathVariable int patronId) {
        BorrowingRecord returnedRecord = borrowingRecordService.returnBook(bookId, patronId);
        borrowingRecordService.modifyAvailableCopies(bookId, 1);
        return ResponseEntity.ok(returnedRecord);
    }
}
