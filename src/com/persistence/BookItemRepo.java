package com.persistence;

import com.model.BookItem;

import java.util.List;

public interface BookItemRepo {
    List<BookItem> getBookItemList() throws Exception;
}
