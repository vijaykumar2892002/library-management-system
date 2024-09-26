package com.library;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {
    private Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Book with this ISBN already exists.");
        }
        books.put(book.getIsbn(), book);
    }

    public void borrowBook(String isbn) {
        Book book = books.get(isbn);
        if (book == null || !book.isAvailable()) {
            throw new IllegalArgumentException("Book is not available.");
        }
        book.borrowBook();
    }

    public void returnBook(String isbn) {
        Book book = books.get(isbn);
        if (book == null || book.isAvailable()) {
            throw new IllegalArgumentException("Invalid return attempt.");
        }
        book.returnBook();
    }


}
