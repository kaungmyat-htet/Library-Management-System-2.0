package com.model;

public interface Search {
    public void searchByTitle(String bookTitle);
    public void searchByAuthor(String authorName);
    public void searchBySubject(BookSubject subject);
}
