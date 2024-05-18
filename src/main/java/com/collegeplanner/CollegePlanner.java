package com.collegeplanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CollegePlanner extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Login login = new Login(primaryStage);
        primaryStage.setScene(login.loginScene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }
}
