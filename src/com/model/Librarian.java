package com.model;

import java.time.LocalDate;

public class Librarian extends User{
    public Librarian(String firstName, String lastName, Account account) {
        super(firstName, lastName, account);
    }

    @Override
    public void issueBook() {
        System.out.println("This is called by librarian.");
        String memberId = scanMemberBarcode();
        System.out.println("Second, scan the book barcode.");
        System.out.println("Finish");
    }

    public String scanMemberId() {
        String memberBarcode = "13455";
        return memberBarcode;
    }

//    public Librarian(String firstName, String lastName, String citizenId, LocalDate dob, String telephone, Address address, Account account) {
//        super(firstName, lastName, citizenId, dob, telephone, address, account);
//    }

    public void addNewBook() {

    }
}
