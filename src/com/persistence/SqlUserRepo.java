package com.persistence;

import com.model.*;
import com.util.ExceptionHandler;

import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class SqlUserRepo implements UserRepo{
    @Override
    public Optional<User> getByUsername(String username) throws Exception{
        try (Connection connection = DriverManager.getConnection(DbConnect.URL,DbConnect.DEFAULT_USERNAME, DbConnect.DEFAULT_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT u.first_name, u.last_name, u.cid, u.dob, u.phone, a.street, a.city, a.zipcode, s.name AS state, c.name AS country, d.status FROM users u INNER JOIN address a ON a.id = u.address_id INNER JOIN state s ON a.state_id = s.id INNER JOIN country c ON s.country_id = c.id INNER JOIN account d ON d.cid = u.cid WHERE u.cid = (SELECT cid FROM account WHERE username = ? );");) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String cid = resultSet.getString("cid");
                    LocalDate dob = resultSet.getDate("dob").toLocalDate();
                    String phone = resultSet.getString("phone");
                    String streetAddress = resultSet.getString("street");
                    String city = resultSet.getString("city");
                    String zipcode = resultSet.getString("zipcode");
                    String state = resultSet.getString("state");
                    String country = resultSet.getString("country");
                    AccountStatus[] statuses = AccountStatus.values();
                    int status = resultSet.getInt("status");
                    Address address = new Address(streetAddress, city, state, zipcode, country);
                    Person personInfo = new Person(firstName, lastName, cid, dob, phone, address);
                    Account account = new Account(username, "*******", statuses[status - 1]);
                    User user = new User(personInfo, account);
                    return Optional.of(user);
                }
            }
        }
        return Optional.empty();
    }
}
