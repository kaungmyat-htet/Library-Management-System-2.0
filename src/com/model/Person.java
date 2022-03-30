package com.model;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String lastName;
    private String citizenId;
    private LocalDate dob;
    private String telephone;
    private Address address;

    public Person(String firstName, String lastName, String citizenId, LocalDate dob, String telephone, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenId = citizenId;
        this.dob = dob;
        this.telephone = telephone;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getTelephone() {
        return telephone;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", citizenId='" + citizenId + '\'' +
                ", dob=" + dob +
                ", telephone='" + telephone + '\'' +
                ", address=" + address +
                '}';
    }
}
