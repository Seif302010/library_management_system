package com.lms.library_management_system.repositories;

import com.lms.library_management_system.models.database_models.Book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b WHERE b.title = :title")
    Optional<Book> findByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.ISBN = :isbn")
    Optional<Book> findByIsbn(String isbn);
}
