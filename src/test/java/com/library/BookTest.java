package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void testCreateBook() {
        Book book = new Book("12345", "Java Programming", "John Doe", 2020);
        assertEquals("12345", book.getIsbn());
        assertEquals("Java Programming", book.getTitle());
        assertEquals("John Doe", book.getAuthor());
        assertEquals(2020, book.getPublicationYear());
        assertTrue(book.isAvailable());
    }

    @Test
    void testBorrowBook() {
        Book book = new Book("12345", "Java Programming", "John Doe", 2020);
        book.borrowBook();
        assertFalse(book.isAvailable());
    }

    @Test
    void testReturnBook() {
        Book book = new Book("12345", "Java Programming", "John Doe", 2020);
        book.borrowBook();
        book.returnBook();
        assertTrue(book.isAvailable());
    }

    @Test
    void testBorrowUnavailableBook() {
        Book book = new Book("12345", "Java Programming", "John Doe", 2020);
        book.borrowBook();
        Exception exception = assertThrows(IllegalArgumentException.class, book::borrowBook);
        assertEquals("Book is already borrowed.", exception.getMessage());
    }
}
