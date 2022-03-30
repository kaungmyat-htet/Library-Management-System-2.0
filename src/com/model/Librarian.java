package com.model;

import com.util.ExceptionHandler;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Librarian{
    private Person personInfo;
    private Account account;

    public Librarian(Person personInfo, Account account) {
        this.personInfo = personInfo;
        this.account = account;
    }

    public Person getPersonInfo() {
        return personInfo;
    }

    public Account getAccount() {
        return account;
    }

    public Optional<BorrowTransaction> issueBook(BookItem bookItem) {
        System.out.println("This is called by librarian.");
        String memberId = scanMemberId();
        System.out.println("Second, scan the book barcode.");
        System.out.println("Finish");
        return Optional.empty();
    }

    public void returnBook() {
        System.out.println("Returning book.");
    }

    public String scanMemberId() {
        String memberBarcode = "13455";
        return memberBarcode;
    }

//    public Librarian(String firstName, String lastName, String citizenId, LocalDate dob, String telephone, Address address, Account account) {
//        super(firstName, lastName, citizenId, dob, telephone, address, account);
//    }"

    public void addNewBook(String isbn, String title, String category, int numberOfPages) {
//        Book newBook = new Book(isbn, title, category, numberOfPages);
//        System.out.println(newBook);
        System.out.println("Has been added");
    }

    public void deleteBook(String isbn) {

    }

    public void editBook(String isbn) {

    }

    public void addNewBookItem(BookItem bookItem) {
        System.out.println(bookItem);
        System.out.println("has added!");
    }

    public void registerNewMember() {
        System.out.println("You are registering a new member.");
        Optional<Member> newMember = enterMemberDetails();
        if (newMember.isEmpty()) {
            System.err.println("Error registering new member. Please try again.");
        }
        System.out.println(newMember);
        System.out.println("has registered.");
    }

    public void blockMember(String username) {

    }

    public Optional<Member> enterMemberDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter citizen Id: ");
        String citizenId = scanner.next();
        System.out.print("Enter date of birth: ");
        String dob = scanner.next();
        System.out.print("Enter phone number: ");
        String phone = scanner.next();
        System.out.print("Enter street address: ");
        String streetAddress = scanner.next();
        System.out.print("Enter city: ");
        String city = scanner.next();
        System.out.print("Enter state: ");
        String state = scanner.next();
        System.out.print("Enter zipCode: ");
        String zipCode = scanner.next();
        System.out.print("Enter country: ");
        String country = scanner.next();
        System.out.print("Enter account's username: ");
        String username = scanner.next();
        System.out.print("Enter account's password: ");
        String password = scanner.next();
        try {
            LocalDate dateOfBirth = LocalDate.parse(dob);
            Address memberAddress = new Address(streetAddress, city, state, zipCode, country);
            Person memberInfo = new Person(firstName, lastName, citizenId, dateOfBirth, phone, memberAddress);
            Account memberAccount = new Account(username, password, AccountStatus.ACTIVE);
            LocalDate registeredDate = LocalDate.now();
            LocalDate expiredDate = LocalDate.parse(registeredDate.toString()).plusYears(2L);
            Member member = new Member(memberInfo, memberAccount, registeredDate, expiredDate);
            return Optional.of(member);
        } catch (Exception exception) {
            ExceptionHandler.handleException(exception);
        }
        return Optional.empty();
    }
}
