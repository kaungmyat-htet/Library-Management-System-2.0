package com.persistence;

import com.model.Book;

import java.util.List;

public interface BookRepo {
    List<Book> getBookList();
}
