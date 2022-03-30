package com.view;

import com.controller.BaseController;
import com.controller.LoginWindowController;
import com.controller.MemberWindowController;
import com.controller.ViewProfileController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {
    private ArrayList<Stage> activeStages;
    private Pane view;

    public ViewFactory() {
        this.activeStages = new ArrayList<>();
    }

    public void showLoginWindow() {
        System.out.println("Show Login Window");
        BaseController controller = new LoginWindowController(this, "LoginWindow.fxml");
        initializeStage(controller, "Login Window", false);
    }

    public void showMemberWindow(String username) {
        System.out.println("Show Member Main Window");
        BaseController controller = new MemberWindowController(this, "MemberMainWindow.fxml", username);
        initializeStage(controller, "Member Window", false);
    }

    public void showProfileContent(BorderPane borderPane, String username) {
        System.out.println("Show View Profile Pane");

        BaseController controller = new ViewProfileController(this, "ViewProfilePane.fxml", username);
        view = loadContent(controller);
        borderPane.setCenter(view);
    }

    public Pane loadContent(BaseController controller) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
            fxmlLoader.setController(controller);
            view = fxmlLoader.load();
        } catch (IOException exception) {
            System.out.println("Error in Rendering UI");
            exception.printStackTrace();
        }
        return view;
    }

    private void initializeStage(BaseController controller, String title, boolean hasToWait) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException exception) {
            System.out.println("Error in Rendering UI!");
            exception.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        if (hasToWait) {
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } else {
            stage.show();
        }

        activeStages.add(stage);
    }

    public void closeStage(Stage stageToClose) {
        stageToClose.close();
        activeStages.remove(stageToClose);
    }
}
