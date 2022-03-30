package com.model;

import java.util.Arrays;

public class Book {
    private final String isbn;
    private String title;
    private Author[] authors;
    private BookSubject subject;
    private String language;
    private int numberOfPages;

    public Book(String isbn, String title, Author[] authors, BookSubject subject, String language, int numberOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.subject = subject;
        this.language = language;
        this.numberOfPages = numberOfPages;
    }

    public Book(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public BookSubject getSubject() {
        return subject;
    }

    public String getLanguage() {
        return language;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", subject=" + subject +
                ", language='" + language + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
