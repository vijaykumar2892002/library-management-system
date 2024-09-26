package com.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddBook() {
        Book book = new Book("12345", "Java Programming", "John Doe", 2020);
        library.addBook(book);
        assertEquals("ISBN: 12345, Title: Java Programming", library.viewAvailableBooks());
    }

//    @Test
//    void testBorrowBook() {
//        Book book = new Book("12345", "Java Programming", "John Doe", 2020);
//        library.addBook(book);
//        library.borrowBook("12345");
//        assertThrows(IllegalArgumentException.class, () -> library.borrowBook("12345"));
//    }
//
//    @Test
//    void testReturnBook() {
//        Book book = new Book("12345", "Java Programming", "John Doe", 2020);
//        library.addBook(book);
//        library.borrowBook("12345");
//        library.returnBook("12345");
//        assertTrue(book.isAvailable());
//    }
//
//
//    @Test
//    void testViewAvailableBooks() {
//        Book book1 = new Book("12345", "Java Programming", "John Doe", 2020);
//        Book book2 = new Book("67890", "Python Programming", "Jane Smith", 2021);
//
//        library.addBook(book1);
//        library.addBook(book2);
//
//        String expectedOutput = "ISBN: 12345, Title: Java Programming\nISBN: 67890, Title: Python Programming";
//        assertEquals(expectedOutput, library.viewAvailableBooks());
//    }
}
