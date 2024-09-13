package org.example;

import org.example.book.*;
import org.example.library.Library;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookRepository inMemoryRepository = new InMemoryBookRepository();
        BookRepository fileRepository = new FileBookRepository();

        Library library = new Library(inMemoryRepository);

        Book book1 = new BookBuilder().setTitle("BratanTiger").setAuthor("LOne").setIsbn("123").setPublicationYear(2013).build();
        Book book2 = new BookBuilder().setTitle("Bryshko").setAuthor("Koldaev").setIsbn("456").setPublicationYear(2024).build();

        library.addBook(book1);
        library.addBook(book2);

        List<Book> books = library.listAllBooks();
        books.forEach(System.out::println);

        Book foundBook = library.findBook("456");
        System.out.println("Найденная книга: " + foundBook);
        library.removeBook("456");

        books = library.listAllBooks();
        books.forEach(System.out::println);
    }
}