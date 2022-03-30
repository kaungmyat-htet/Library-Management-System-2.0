package com.persistence;

import com.model.BookItem;
import com.model.DbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SqlBookItemRepo implements BookItemRepo{
    @Override
    public List<BookItem> getBookItemList() throws Exception{
        List<BookItem> bookItemList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DbConnect.URL, DbConnect.DEFAULT_USERNAME, DbConnect.DEFAULT_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM book_item;")) {
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    String barcode = resultSet.getString("barcode");
                    String isbn = resultSet.getString("isbn");
                    Boolean isReference = resultSet.getBoolean("is_reference");
                    int status = resultSet.getInt("status_id");
                    int price = resultSet.getInt("price");
                    LocalDate purchasedDate = resultSet.getDate("date_of_purchased").toLocalDate();
                    LocalDate publicationDate = resultSet.getDate("publication_date").toLocalDate();
                    BookItem.BookItemBuilder builder = new BookItem.BookItemBuilder();
                    //Need changes
                }
            }
        }
        return null;
    }
}
