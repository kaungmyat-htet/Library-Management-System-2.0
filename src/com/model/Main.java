package com.model;

import com.model.*;
import com.util.ExceptionHandler;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        try {
            Person newPerson = new Person("Martin", "Borrex", "19301-2112-111", LocalDate.now(), "0892736362", new Address("Street", "City", "State", "98882", "Country"));
            Account account = new Account("Username", "password", AccountStatus.ACTIVE);
            Librarian librarian = new Librarian(newPerson, account);
            Optional<Member> newMember = librarian.enterMemberDetails();
            System.out.println(newMember);


            Account validAccount = new Account("MU10001", "password", AccountStatus.ACTIVE);
            Optional<User> validUser = validAccount.viewProfile();
            System.out.println(validUser);

        } catch (Exception exception) {
            ExceptionHandler.handleException(exception);
        }
    }
}
