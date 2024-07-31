package com.lms.library_management_system.services.specific_services;

import com.lms.library_management_system.models.database_models.Book;
import com.lms.library_management_system.repositories.BookRepository;
import com.lms.library_management_system.services.generic_services.*;
import org.springframework.stereotype.Service;

@Service
public class BookService extends GenericServiceImpl<Book, Integer> {

    public BookService(BookRepository bookRepository) {
        this.repository = bookRepository;
    }
}
