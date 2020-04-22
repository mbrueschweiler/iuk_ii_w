package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Book;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.*;
import  services.BookService;
import services.DefaultBookService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

public class BookController extends Controller{

    private DefaultBookService bookService;

    @Inject
    public BookController(DefaultBookService bookService) {
        this.bookService = bookService;
    }

    public CompletionStage<Result> books(String q) {
        return bookService.get().thenApplyAsync(bookStream ->
                ok(Json.toJson(bookStream.collect(Collectors.toList())))
        );
    }

    public CompletionStage<Result> add(Http.Request request) {
        final JsonNode json = request.body().asJson();
        final Book bookToPersists = Json.fromJson(json, Book.class);
        return bookService.add(bookToPersists).thenApplyAsync(book -> ok(Json.toJson(book)));
    }

    public CompletionStage<Result> update(Long id, Http.Request request) {
        final JsonNode json = request.body().asJson();
        final Book bookToPersists = Json.fromJson(json, Book.class);
        return bookService.add(bookToPersists).thenApplyAsync(book -> ok(Json.toJson(book)));
    }

    public CompletionStage<Result> details(Long id) {
        return bookService.get(id).thenApplyAsync(book -> ok(Json.toJson(book)));
    }

    public CompletionStage<Result> delete(Long id) {
        return bookService.delete(id).thenApplyAsync(removed -> removed ? ok() : internalServerError());
    }

    public Result dummy() {
        return ok(Json.toJson(bookService.getDummy()));
    }
}
