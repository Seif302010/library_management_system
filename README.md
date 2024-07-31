# Library Management System API

## Overview
This project is a RESTful API for a Library Management System, built using Java and Spring Boot. It allows users to manage books, patrons, and borrowing transactions.

## Features
- **Books Management**: Create, read, update, and delete books.
- **Patrons Management**: Manage patrons with create, read, update, and delete functionality.
- **Borrowing Management**: Facilitate borrowing and returning of books by patrons.

## Technologies Used
- Java 21
- Spring Boot 3.3.2
- Maven
- SQL Server (or XAMPP SQL Database)
- Integrated Security for database connection

## API Endpoints
Below is a list of the available API endpoints:

### Books
- **GET All Books**  
  `GET /api/books`  
  Retrieves all books in the library.

- **GET Book by ID**  
  `GET /api/books/{id}`  
  Retrieves a book by its ID.

- **POST Create Book**  
  `POST /api/books`  
  Creates a new book.  
  **Request Body**:
  ```json
  {
    "title": "book1",
    "author": "author1",
    "publication_year": "2016",
    "ISBN": "555-333-888-222-33"
  }
