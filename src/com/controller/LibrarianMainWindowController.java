package com.controller;

import com.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class LibrarianMainWindowController extends BaseController{
    private String username;

    public LibrarianMainWindowController(ViewFactory viewFactory, String fxmlName, String username) {
        super(viewFactory, fxmlName);
        this.username = username;
    }

    @FXML
    private BorderPane mainWindow;

    @FXML
    void manageBooksButtonAction(ActionEvent event) {
        System.out.println("Manage Books Button Clicked");
    }

    @FXML
    void logoutButtonAction(ActionEvent event) {
        System.out.println("Log out button clicked");
    }

    @FXML
    void returnBookButtonAction(ActionEvent event) {
        System.out.println("Return Button Clicked");
    }

    @FXML
    void searchCatalogueButtonAction(ActionEvent event) {
        System.out.println("Search Catalogue Button Clicked");
    }

    @FXML
    void viewProfileButtonAction(ActionEvent event) {
        System.out.println("View Profile Button Clicked");

        viewFactory.showProfileContent(mainWindow, username);
    }
}
