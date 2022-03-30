package com.controller;

import com.model.DbConnect;
import com.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Locale;

public class LoginWindowController extends BaseController{
    public LoginWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    void loginButtonAction(ActionEvent event) throws Exception {
        System.out.println("Login Button Clicked");
        String username, password;
        username = usernameTextField.getText().toUpperCase(Locale.ROOT);
        password = passwordField.getText();
        System.out.println(username + " " + password);
        DbConnect dbConnect = new DbConnect();
        int userType = dbConnect.userLogin(username, password);
        switch (userType) {
            case 1:
                System.out.println("You are the manager!");
                viewFactory.showMemberWindow(username);
                closeThisWindow();
                break;
            case 2:
                System.out.println("You are the librarian!");
                viewFactory.showMemberWindow(username);
                closeThisWindow();
                break;
            case 3:
                viewFactory.showMemberWindow(username);
                closeThisWindow();
                break;
            default:
                System.out.println("Invalid user!");
                break;
        }
    }

    void closeThisWindow() {
        Stage loginWindow = (Stage) usernameTextField.getScene().getWindow();
        viewFactory.closeStage(loginWindow);
    }

}
