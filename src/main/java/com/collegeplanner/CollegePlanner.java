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

        Stage newStudentStage = new Stage(StageStyle.UNDECORATED);
        Stage exitStage = new Stage(StageStyle.UNDECORATED);

        Login login = new Login(primaryStage, exitStage, newStudentStage);
        primaryStage.setScene(login.loginScene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }
}
