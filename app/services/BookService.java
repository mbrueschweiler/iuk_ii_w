package services;

import models.Book;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

public interface BookService {

    /**
     * Return's list of all books.
     * @return list of all books
     */
    CompletionStage<Stream<Book>> get();

    /**
     * Returns books with given identifier.
     * @param id card identifier
     * @return book with given identifier or {@code null}
     */
    CompletionStage<Book> get(final Long id);

    /**
     * Removes book with given identifier.
     * @param id book identifier
     * @return {@code true} on success  {@code false} on failure
     */
    CompletionStage<Boolean> delete(Long id);

    /**
     * Updates book with given identifier.
     * @param updatedBook card with updated fields
     * @return updated book
     */
    CompletionStage<Book> update(final Book updatedBook);

    /**
     * Adds the given card.
     * @param book to add
     * @return added book
     */
    CompletionStage<Book> add(final Book book);

    Book getDummy();
}
