package com.controller;

import com.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class MemberWindowController extends BaseController{
    String username;
    public MemberWindowController(ViewFactory viewFactory, String fxmlName, String username) {
        super(viewFactory, fxmlName);
        this.username = username;
    }

    @FXML
    private BorderPane mainWindow;

    @FXML
    void borrowBookButtonAction(ActionEvent event) {
        System.out.println("Borrow Book Button Clicked");
    }

    @FXML
    void logoutButtonAction(ActionEvent event) {
        System.out.println("Logout Button Clicked");
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
