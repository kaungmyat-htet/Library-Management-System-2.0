package com.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

public class DbConnect {
    private static final String URL = "jdbc:postgresql://localhost:5432/library_management";
    private static final String DEFAULT_USERNAME = "postgres";
    private static final String DEFAULT_PASSWORD = "2022";

    public void testConnection() throws Exception {
        try (Connection connection = DriverManager.getConnection(URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
            Statement statement = connection.createStatement()) {
            System.out.println("Yay! Success");
        }
    }

    public boolean executeQuery(String query) throws Exception{
        boolean isSuccess = false;
        try (Connection connection = DriverManager.getConnection(URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ) {
            try(ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Query Executed Successfully.");
                    isSuccess = true;
                }
            }
        }
        return isSuccess;
    }

    public int userLogin(String username, String password) throws Exception {
        int type = 0;
        try (Connection connection = DriverManager.getConnection(URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM account WHERE username = ? AND password = crypt(?, password);");) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    type = resultSet.getInt("type");
                }
            }
        }
        return type;
    }

    public ArrayList<String> getStateList(String country) throws Exception{
        ArrayList<String> states = new ArrayList<String>();
        String state;
        try (Connection connection = DriverManager.getConnection(URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM state WHERE country_id  = " +
                "(SELECT id FROM country WHERE iso_code = ?);");) {
            statement.setString(1, country.toUpperCase(Locale.ROOT));
            System.out.println(statement.toString());
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    state = resultSet.getString("name");
                    states.add(state);
                }
            }
        }
        return states;
    }
}
