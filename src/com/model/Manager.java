package com.model;

public class Manager extends Librarian{
    public Manager(String firstName, String lastName, Account account) {
        super(firstName, lastName, account);
    }

    public void addLibrarian(Librarian newLibrarian) {
        System.out.println(newLibrarian + " added");
    }
}
