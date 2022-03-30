package com.model;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class User {
    private Person personInfo;
    private Account account;

    public User(Person personInfo, Account account) {
        this.personInfo = personInfo;
        this.account = account;
    }

    public Person getPersonInfo() {
        return personInfo;
    }

    public Account getAccount() {
        return account;
    }

    public Optional<BorrowTransaction> issueBook(BookItem bookItem) { return Optional.empty(); }

    public void returnBook() {

    }

    public String scanBook() {
        System.out.print("Scan the book barcode: ");
        Scanner scanner = new Scanner(System.in);
        String barcode = scanner.next();
        return barcode;
    }

    public void login(String username, String password) throws Exception {
        boolean isSuccess = false;
        if (isSuccess) {
            System.out.println("Yay! login success.");
        } else {
            System.out.println("Login Failed!");
        }
    }

    public void browseBook() {
        System.out.println("Browsing book from the catalog!");
    }

    @Override
    public String toString() {
        return "User{" +
                "personInfo=" + personInfo +
                ", account=" + account +
                '}';
    }
}
