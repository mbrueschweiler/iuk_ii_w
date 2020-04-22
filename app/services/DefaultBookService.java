package services;

import models.Book;
import repository.BookRepository;

import java.util.ArrayList;
import  java.util.List;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

public class DefaultBookService implements BookService {

    private BookRepository bookRepository;

    @Inject
    public DefaultBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getDummy() {
        final Book book = new Book();
        book.setId(1l);
        book.setDescription("Diese Buch ist ein Test");
        book.setIsbn10("3827420237");
        book.setIsbn13("978-3827420237");
        book.setPages(150);
        book.setPublisher("Test Verlag");
        book.setTitle("Testbuch");
        return book;
    }

    public CompletionStage<Stream<Book>> get() {
        return bookRepository.list();
    }

    public CompletionStage<Book> get(final Long id) {
        return bookRepository.find(id);
    }

    public CompletionStage<Boolean> delete(final Long id) {
        return bookRepository.remove(id);
    }

    public CompletionStage<Book> update(Book book) {
        return  bookRepository.update(book);
    }

    public CompletionStage<Book> add(Book book) {
        return bookRepository.add(book);
    }

}
