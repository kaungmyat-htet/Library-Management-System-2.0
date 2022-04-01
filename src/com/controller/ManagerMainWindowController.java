package com.controller;

import com.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class ManagerMainWindowController extends BaseController{
    private String username;

    public ManagerMainWindowController(ViewFactory viewFactory, String fxmlName, String username) {
        super(viewFactory, fxmlName);
        this.username = username;
    }

    @FXML
    private BorderPane mainWindow;

    @FXML
    void logoutButtonAction(ActionEvent event) {
        System.out.println("Log out button Clicked");
    }

    @FXML
    void manageBooksButtonAction(ActionEvent event) {
        System.out.println("Manage Books button Clicked");
    }

    @FXML
    void manageLibrariansButtonAction(ActionEvent event) {
        System.out.println("Manage Librarians button Clicked");
    }

    @FXML
    void returnBookButtonAction(ActionEvent event) {
        System.out.println("Return Book Button Clicked");
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
