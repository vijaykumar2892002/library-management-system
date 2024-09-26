package com.library;

import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1 -> addBook();
                case 2 -> borrowBook();
                case 3 -> returnBook();
//                case 4 -> viewAvailableBooks();
                case 5 -> exit = true;
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nLibrary Management System:");
        System.out.println("1. Add Book");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. View Available Books");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addBook() {
        System.out.print("Enter ISBN (at least 5 characters): ");
        String isbn = scanner.nextLine().trim();
        if (isbn.length() < 5) {
            System.out.println("Invalid ISBN. It should be at least 5 characters long.");
            return;
        }

        System.out.print("Enter Title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();
        if (author.isEmpty()) {
            System.out.println("Author name cannot be empty.");
            return;
        }

        System.out.print("Enter Publication Year: ");
        try {
            int year = Integer.parseInt(scanner.nextLine().trim());
            if (year < 1000 || year > 9999) { // Example range check for the year
                System.out.println("Invalid publication year. Please enter a valid 4-digit year.");
                return;
            }

            Book book = new Book(isbn, title, author, year);
            try {
                library.addBook(book);
                System.out.println("Book added successfully.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number for the publication year.");
        }
    }


    private static void borrowBook() {
        System.out.print("Enter ISBN of the book to borrow: ");
        String isbn = scanner.nextLine();
        try {
            library.borrowBook(isbn);
            System.out.println("Book borrowed successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void returnBook() {
        System.out.print("Enter ISBN of the book to return: ");
        String isbn = scanner.nextLine();
        try {
            library.returnBook(isbn);
            System.out.println("Book returned successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
//
//    private static void viewAvailableBooks() {
//        System.out.println("Available Books:");
//        System.out.println(library.viewAvailableBooks());
//    }
}
