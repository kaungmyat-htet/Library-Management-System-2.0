module Library{
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires javafx.graphics;

    opens com.controller;
    opens com.view;
    opens com.model;
    opens com;

    exports com.model;
}