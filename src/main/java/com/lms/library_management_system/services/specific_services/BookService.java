package com.lms.library_management_system.services.specific_services;

import com.lms.library_management_system.exceptions.InvalidException;
import com.lms.library_management_system.models.database_models.Book;
import com.lms.library_management_system.repositories.BookRepository;
import com.lms.library_management_system.services.generic_services.*;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService extends GenericServiceImpl<Book, Integer> {
    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    @Override
    public void validatePost(Book book) {

        Map<String, String> errorMessages = new HashMap<>();

        if (book.available_copies < 0) {
            errorMessages.put("available_copies", "cannot be negative");
        }
        if (book.title == null || book.title.trim().isEmpty()) {
            errorMessages.put("title", "cannot be null or empty");
        }
        if (book.author == null || book.author.trim().isEmpty()) {
            errorMessages.put("author", "cannot be null or empty");
        }
        if (book.ISBN == null || book.ISBN.trim().isEmpty()) {
            errorMessages.put("ISBN", "cannot be null or empty");
        }
        if (book.publication_year == null || book.publication_year.trim().isEmpty()) {
            errorMessages.put("publication_year", "cannot be null or empty");
        }
        if (bookRepository.findByTitle(book.title).isPresent()) {
            errorMessages.put(book.title, "there is a book with this title");
        }

        if (bookRepository.findByIsbn(book.ISBN).isPresent()) {
            errorMessages.put(book.ISBN, "there is a book with this serial");
        }
        if (!errorMessages.isEmpty()) {
            throw new InvalidException(errorMessages);
        }
    }

    @Override
    public void validatePut(Integer id, Book book) {
        Map<String, String> errorMessages = new HashMap<>();

        if (bookRepository.findByTitle(book.title).isPresent() &&
                bookRepository.findByTitle(book.title).get().getId() != id) {
            errorMessages.put(book.title, "there is a book with this title");
        }

        if (bookRepository.findByIsbn(book.ISBN).isPresent() &&
                bookRepository.findByIsbn(book.ISBN).get().getId() != id) {
            errorMessages.put(book.ISBN, "there is a book with this serial");
        }

        if (!errorMessages.isEmpty()) {
            throw new InvalidException(errorMessages);
        }
    }
}
