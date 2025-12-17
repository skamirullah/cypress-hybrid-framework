package com.skamirullah.models.request;

public class AddBookRequest {

    private String name;
    private String isbn;
    private String aisle;
    private String author;

    public AddBookRequest() {
    }

    public AddBookRequest(String name, String isbn, String aisle, String author) {
        this.name = name;
        this.isbn = isbn;
        this.aisle = aisle;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAisle() {
        return aisle;
    }

    public String getAuthor() {
        return author;
    }
}