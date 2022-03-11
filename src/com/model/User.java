package com.model;

import java.time.LocalDate;

public abstract class User {
    private String firstName;
    private String lastName;
//    private String citizenId;
//    private LocalDate dob;
//    private String telephone;
//    private Address address;
    private Account account;

//    public User(String firstName, String lastName, String citizenId, LocalDate dob, String telephone, Address address, Account account) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.citizenId = citizenId;
//        this.dob = dob;
//        this.telephone = telephone;
//        this.address = address;
//        this.account = account;
//    }


    public User(String firstName, String lastName, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }

    public abstract void issueBook();

    public String scanBook() {
        String barcode = "4567930293";
        return barcode;
    }

    public void login(String username, String password) {
        if (username.equals(account.getUsername()) && password.equals(account.getPassword())) {
            System.out.println("Yay! login success.");
        } else {
            System.out.println("Login Failed!");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", account=" + account +
                '}';
    }
}
