package com.model;

import java.time.LocalDate;

public class BorrowTransaction {
    private String username;
    private BookItem bookItem;
    private LocalDate creationDate;
    private LocalDate dueDate;

    public BorrowTransaction(String username, BookItem bookItem, LocalDate creationDate, LocalDate dueDate) {
        this.username = username;
        this.bookItem = bookItem;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "BorrowTransaction{" +
                "username='" + username + '\'' +
                ", bookItem=" + bookItem +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
