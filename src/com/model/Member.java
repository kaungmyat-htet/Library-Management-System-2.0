package com.model;

import java.time.LocalDate;
import java.util.Optional;

public class Member implements IssueBook {
    private Person personInfo;
    private Account account;
    private LocalDate registeredDate;
    private LocalDate expiredMembership;
    private int totalBookBorrowed;

    public Member(Person person, Account account, LocalDate registeredDate, LocalDate expiredMembership, int totalBookBorrowed) {
        this.personInfo = person;
        this.account = account;
        this.registeredDate = registeredDate;
        this.expiredMembership = expiredMembership;
        this.totalBookBorrowed = totalBookBorrowed;
    }

    public Member(Person person, Account account, LocalDate registeredDate, LocalDate expiredMembership) {
        this.personInfo = person;
        this.account = account;
        this.registeredDate = registeredDate;
        this.expiredMembership = expiredMembership;
        this.totalBookBorrowed = 0;
    }

    public Person getPersonInfo() {
        return personInfo;
    }

    public Account getAccount() {
        return account;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public LocalDate getExpiredMembership() {
        return expiredMembership;
    }

    public int getTotalBookBorrowed() {
        return totalBookBorrowed;
    }

    public void returnBook() {
        System.out.println("Returning Book");
    }

    @Override
    public String toString() {
        return "Member{" +
                "personInfo=" + personInfo +
                ", account=" + account +
                ", registeredDate=" + registeredDate +
                ", expiredMembership=" + expiredMembership +
                ", totalBookBorrowed=" + totalBookBorrowed +
                '}';
    }

    @Override
    public Optional<BorrowTransaction> issueBook(BookItem bookToBorrow) {
        bookToBorrow.borrowBook(this.getAccount().getUsername());
        if (!bookToBorrow.isReference() && bookToBorrow.getStatus() == BookStatus.AVAILABLE) {
//            bookToBorrow.setStatus(BookStatus.LOANED);
            LocalDate creationDate = LocalDate.now();
            LocalDate dueDate = creationDate.plusDays(BookItem.allowedPeriod);
            BorrowTransaction borrowTransaction = new BorrowTransaction(this.getAccount().getUsername(), bookToBorrow, creationDate, dueDate);
            return Optional.of(borrowTransaction);
        }
        if (bookToBorrow.isReference()) {
            System.out.println("Sorry you cannot borrowed this book. This is only for reference only.");
        }
        if (bookToBorrow.getStatus() != BookStatus.AVAILABLE) {
            System.out.println("This book is not available and borrowed by other member.");
        }
        return Optional.empty();
    }
}
