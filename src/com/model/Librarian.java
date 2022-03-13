package com.model;

import java.time.LocalDate;
import java.util.Scanner;

public class Librarian extends User{
    public Librarian(String firstName, String lastName, Account account) {
        super(firstName, lastName, account);
    }

    @Override
    public void issueBook() {
        System.out.println("This is called by librarian.");
        String memberId = scanMemberId();
        System.out.println("Second, scan the book barcode.");
        System.out.println("Finish");
    }

    public String scanMemberId() {
        String memberBarcode = "13455";
        return memberBarcode;
    }

//    public Librarian(String firstName, String lastName, String citizenId, LocalDate dob, String telephone, Address address, Account account) {
//        super(firstName, lastName, citizenId, dob, telephone, address, account);
//    }"

    public void addNewBook(String isbn, String title, String category, int numberOfPages) {
        Book newBook = new Book(isbn, title, category, numberOfPages);
        System.out.println(newBook);
        System.out.println("Has been added");
    }

    public void deleteBook() {

    }

    public void editBook() {

    }

    public void addNewBookItem(BookItem bookItem) {
        System.out.println(bookItem);
        System.out.println("has added!");
    }

    public void registerNewMember() {
        System.out.println("You are registering a new member.");
        Member newMember = enterMemberDetails();
        System.out.println(newMember);
        System.out.println("has registered.");
    }

    public Member enterMemberDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter account's username: ");
        String username = scanner.next();
        System.out.print("Enter account's password: ");
        String password = scanner.next();
        Account memberAccount = new Account(username, password);
        LocalDate registeredDate = LocalDate.now();
        LocalDate expiredDate = LocalDate.parse(registeredDate.toString()).plusYears(2L);
        Member member = new Member(firstName, lastName, memberAccount, registeredDate, expiredDate);
        return member;
    }
}
