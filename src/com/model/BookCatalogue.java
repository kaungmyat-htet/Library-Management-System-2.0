package com.model;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class BookCatalogue {
    private static Map<String, Book> bookMap = Map.of(
            "10239", new Book("10239", "Jungle In The Wood", new Author[] {new Author(1, "Jacki")}, BookSubject.LiteratureFiction, "English", 300),
            "29938", new Book("29938", "Atomic Habit", new Author[] {new Author(2, "James Clear")}, BookSubject.SelfHelp, "English", 320)
    );

    public static Book getBook(String bookIsbn) {
        return bookMap.get(bookIsbn);
    }
}
