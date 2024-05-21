package com.collegeplanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CollegePlanner extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage exitStage = new Stage();
        exitStage.initStyle(StageStyle.UNDECORATED);

        Login login = new Login(primaryStage, exitStage);
        primaryStage.setScene(login.loginScene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }
}
