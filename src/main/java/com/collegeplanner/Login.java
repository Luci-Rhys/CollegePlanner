package com.collegeplanner;


import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class Login extends Window {
    Scene loginScene;
    private Stage loginStage;

    public Login(Stage loginStage){
        super(loginStage);
        this.loginScene = createLoginScene();
        this.loginStage = loginStage;
        linkStyleSheet("/css/login-styling.css", loginScene);
    }

    public Scene createLoginScene(){
        Scene loginScene;
        BorderPane loginSceneLayout = createLoginSceneLayout();
        loginScene = new Scene(loginSceneLayout, 1175, 800);
        loginSceneLayout.requestFocus();
        return loginScene;
    }

    private BorderPane createLoginSceneLayout(){
        BorderPane loginSceneLayout;
        StackPane loginWindow;
        StackPane loginWindowCont;
        Region top, left, right, bottom;

        //Pane initialization
        top = new Region();
        left = new Region();
        loginWindow = createLoginPane();
        right = new Region();
        bottom = bottomPane();
        loginWindowCont = new StackPane(loginWindow);

        //Containers
        HBox toolbar = new HBox();
        toolbar.setPrefSize(1175,30);

        VBox tbTop = new VBox(toolbar, top);
        dragWindow(toolbar);


        //BorderPane initialization and assignment
        loginSceneLayout = new BorderPane();
        loginSceneLayout.setTop(tbTop);
        loginSceneLayout.setLeft(left);
        loginSceneLayout.setCenter(loginWindowCont);
        loginSceneLayout.setRight(right);
        loginSceneLayout.setBottom(bottom);

        /*
        The remaining code until the return statement is the CSS
         */
        linkStyle(tbTop, "top-pane");
        linkStyle(tbTop, "pane-size");
        linkStyle(left, "left-pane");
        linkStyle(left, "pane-size");
        linkStyle(right, "right-pane");
        linkStyle(right, "pane-size");
        linkStyle(bottom, "bottom-pane");
        linkStyle(bottom, "pane-size");
        linkStyle(loginWindow, "center-pane");

        return loginSceneLayout;
    }

    //Creates the Pane for the login window
    private StackPane createLoginPane() {
        StackPane loginWindow;
        Label signIn, username, password, orSeparator, incorrect;
        Button createNewAcct, login, forgotPW;
        Separator hzDivLeft, hzDivRight, verDiv;
        TextField usernameTF;
        PasswordField passwordPF;

        //BorderPane initializations
        loginWindow = new StackPane();

        //Label Initializations
        signIn = new Label("Sign in to your CP account");
        username = new Label("Username/Email");
        password = new Label("Password");
        orSeparator = new Label("or");
        incorrect = new Label("Incorrect email or password");

        //Button initializations
        createNewAcct = new Button("Create New Account");

        login = new Button("Login");
        forgotPW = new Button("Forgot Password?");

        //Logo initialization
        Image logo = new Image(getClass().getResourceAsStream("/images/training.png")); //temp placeholder, will be updated
        ImageView logoView = new ImageView(logo);;

        //Separator initializations
        verDiv = new Separator(Orientation.VERTICAL);
        hzDivLeft = new Separator(Orientation.HORIZONTAL);
        hzDivRight = new Separator(Orientation.HORIZONTAL);

        //TextField initializations
        usernameTF = new TextField();
        usernameTF.setPromptText("enter your email");

        //PasswordField initialization
        passwordPF = new PasswordField();
        passwordPF.setPromptText("enter your password");

        /*
        Containers
         */
        VBox verDivCont  = new VBox(verDiv);

        //Sign in label container
        HBox signInLabel = new HBox(signIn);

        //Logo container
        HBox imageCont = new HBox(logoView);

        //Username Container
        VBox unLblAndTFCont = new VBox(username, usernameTF);

        //Password Container
        HBox pwLblAndforgotPWBtn = new HBox(password, forgotPW);
        VBox pwLblAndTFCont = new VBox(pwLblAndforgotPWBtn, passwordPF);

        //Horizontal Separator Container
        HBox hzDivLeftCont = new HBox(hzDivLeft);
        HBox hzDivRightCont = new HBox(hzDivRight);

        //Create Account Button Container
        HBox newAcctBtnCont = new HBox(createNewAcct);

        //Separator with "or" in the middle
        HBox orSepCont = new HBox(orSeparator);
        HBox sepAndLbl = new HBox(hzDivLeftCont, orSepCont, hzDivRightCont);

        //Login button container
        HBox loginBtnCont = new HBox(login);

        VBox txtFldsAndBtns = new VBox(unLblAndTFCont, pwLblAndTFCont, loginBtnCont, sepAndLbl, newAcctBtnCont);
        HBox centerPaneCnt = new HBox(imageCont, verDivCont);
        VBox rightPaneCnt = new VBox(signInLabel, txtFldsAndBtns);
        HBox loginWinCont = new HBox(centerPaneCnt, rightPaneCnt);

        //StackPane assignment
        loginWindow.getChildren().add(loginWinCont);

        /*
        From here until the return statement is the CSS link to styling
         */

        //Logo
        linkStyle(imageCont, "logo-style");

        //Buttons
        linkStyle(login, "login-button");
        linkStyle(createNewAcct, "newAcctBtn");
        linkStyle(forgotPW, "forgot-pw");

        //Labels
        linkStyle(signInLabel, "sign-in-label");
        linkStyle(username, "field-label");
        linkStyle(password, "field-label");
        linkStyle(orSeparator, "or-label");

        //Containers
        linkStyle(centerPaneCnt, "center-pane");
        linkStyle(loginWinCont, "login-pane");
        linkStyle(txtFldsAndBtns, "txtFldsAndBtns");
        linkStyle(imageCont, "logo-style");
        linkStyle(rightPaneCnt, "right-pane-style");
        linkStyle(newAcctBtnCont, "create-account");
        linkStyle(hzDivLeftCont, "hz-left-divider-cont");
        linkStyle(hzDivRightCont, "hz-right-divider-cont");
        linkStyle(unLblAndTFCont, "un-comp-container");
        linkStyle(pwLblAndTFCont, "pw-comp-container");
        linkStyle(loginBtnCont, "login-btn-cont");
        linkStyle(sepAndLbl, "sepCont");
        linkStyle(orSepCont, "or-label-cont");
        linkStyle(loginWindow, "login-window");

        //Dividers
        linkStyle(verDiv, "ver-divider");
        linkStyle(hzDivLeft, "horizontal-divider");
        linkStyle(hzDivRight, "horizontal-divider");

        return loginWindow;
    }

    //Creates bottom pane with logout button
    private Pane bottomPane (){
        //Creates and adds graphic to button
        Button exit = new Button();
        Image power = new Image(getClass().getResourceAsStream("/images/exit.png"));
        ImageView powerGraphic = new ImageView(power);
        exit.setGraphic(powerGraphic);

        //Button container and addition to bottomPane
        HBox exitBtnCont = new HBox(exit);
        Pane bottomPane = new Pane(exitBtnCont);
        exitBtnCont.setAlignment(Pos.CENTER);

        //Exit event handler
        exit.setOnAction(e -> {
            Platform.exit();
        });

        //CSS Styling
        exit.getStyleClass().add("power-btn");
        exitBtnCont.getStyleClass().add("power-btn-cont");

        return bottomPane;
    }
}
