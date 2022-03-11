package com.model;

import java.time.LocalDate;

public class Member extends User{
    public Member(String firstName, String lastName, Account account) {
        super(firstName, lastName, account);
    }

    @Override
    public void issueBook() {
        System.out.println("This is called by member.");
        super.scanBook();
        System.out.println("Finish");
    }

//    public Member(String firstName, String lastName, String citizenId, LocalDate dob, String telephone, Address address, Account account) {
//        super(firstName, lastName, citizenId, dob, telephone, address, account);
//    }


}
