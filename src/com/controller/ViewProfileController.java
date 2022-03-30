package com.controller;

import com.model.Account;
import com.model.Address;
import com.model.User;
import com.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ViewProfileController extends BaseController implements Initializable {
    String username;
    public ViewProfileController(ViewFactory viewFactory, String fxmlName, String username) {
        super(viewFactory, fxmlName);
        this.username = username;
    }

    @FXML
    private Label accStatusLabel;

    @FXML
    private Label cidLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label countryLabel;

    @FXML
    private Label dobLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label stateLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label zipCodeLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Account loginAccount = new Account(username);
        try {
            Optional<User> loginUser = loginAccount.viewProfile();
            if (!loginUser.isEmpty()) {
                firstNameLabel.setText(loginUser.get().getPersonInfo().getFirstName());
                lastNameLabel.setText(loginUser.get().getPersonInfo().getLastName());
                cidLabel.setText(loginUser.get().getPersonInfo().getCitizenId());
                dobLabel.setText(loginUser.get().getPersonInfo().getDob().toString());
                phoneLabel.setText(loginUser.get().getPersonInfo().getTelephone());
                Address userAddress = loginUser.get().getPersonInfo().getAddress();
                streetLabel.setText(userAddress.getStreetAddress());
                stateLabel.setText(userAddress.getState());
                zipCodeLabel.setText(userAddress.getZipCode());
                cityLabel.setText(userAddress.getCity());
                countryLabel.setText(userAddress.getCountry());
                Account userAccount = loginUser.get().getAccount();
                usernameLabel.setText(userAccount.getUsername());
                accStatusLabel.setText(userAccount.getStatus().toString());
            }
        } catch (Exception e) {
            com.util.ExceptionHandler.handleException(e);
        }
    }
}
