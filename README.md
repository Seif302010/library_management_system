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
  
- **PUT Update Book**  
  `PUT /api/books/{id}`  
  Updates the details of an existing book by ID.

- **DELETE Book**  
  `DELETE /api/books/{id}`  
  Deletes a book by its ID.

### Patrons
- **GET All Patrons**  
  `GET /api/patrons`  
  Retrieves all patrons in the library.

- **GET Patron by ID**  
  `GET /api/patrons/{id}`  
  Retrieves a patron by their ID.

- **POST Create Patron**  
  `POST /api/patrons`  
  Creates a new patron.  
  **Request Body**:
  ```json
  {
    "name": "author1",
    "email": "author1@gmail.com",
    "phone_number": "+23349995555"
  }

- **PUT Update Patron**  
  `PUT /api/patrons/{id}`  
  Updates the details of an existing patron by ID.

- **DELETE Patron**  
  `DELETE /api/patrons/{id}`  
  Deletes a patron by their ID.

### Borrowing
- **Borrow a Book**  
  `POST /api/borrow/{bookId}/patron/{patronId}`  
  Records the borrowing of a book by a patron.

- **Return a Book**  
  `PUT /api/borrow/{bookId}/patron/{patronId}`  
  Records the return of a book by a patron.

## Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/Seif302010/library_management_system.git
   cd library_management_system

2. Build the project using Maven:
   ```bash
   mvn clean install
3. Run the application:
   ```bash
   mvn spring-boot:run
4. Access the API at http://localhost:8080

## Acknowledgments
- Inspired by various online resources and documentation for Spring Boot.
