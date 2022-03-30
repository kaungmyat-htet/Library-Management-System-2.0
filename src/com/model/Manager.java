package com.model;

public class Manager extends Librarian{
    public Manager(Person personInfo, Account account) {
        super(personInfo, account);
    }

    public void addLibrarian(Librarian newLibrarian) {
        System.out.println(newLibrarian + " added");
    }
}
