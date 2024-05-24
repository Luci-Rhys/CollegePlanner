package com.collegeplanner;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Login extends Window {
    Scene loginScene;
    private Stage loginStage;
    private Stage exitStage;
    private Stage newStudentStage;

    public Login(Stage loginStage, Stage exitStage, Stage newStudentStage){
        this.loginStage = loginStage;
        this.exitStage = exitStage;
        this.newStudentStage = newStudentStage;
        this.loginScene = createLoginScene();
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
        dragWindow(toolbar, loginStage);

        VBox tbTop = new VBox(toolbar, top);

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
        linkStyle(toolbar, "login-toolbar");

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

        //Button handlers
        loginSceneBtnHandlers(login, createNewAcct, forgotPW);

        //Logo initialization
        Image logo = new Image(getClass().getResourceAsStream("/images/logo.png")); //temp placeholder, will be updated
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
            exitPopUp(exitStage);
        });

        //CSS Styling
        exit.getStyleClass().add("power-btn");
        exitBtnCont.getStyleClass().add("power-btn-cont");

        return bottomPane;
    }

    private void exitPopUp(Stage exitStage){
        Scene exitScene;

        //Custom toolbar to match look of the rest of the program
        Label exit = new Label("College Planner");
        HBox custTool = new HBox(exit);
        dragWindow(custTool, exitStage);

        //Popup message confirming exit
        Label exitConfLbl = new Label("Are you sure you want to exit?");

        //Yes and cancel buttons
        Button confExitBtn = new Button("Yes");
        Button cancel = new Button("Cancel");

        //Containers
        HBox exitConfLblCont = new HBox(exitConfLbl);
        HBox exitBtnsCont = new HBox(confExitBtn, cancel);
        VBox exitPopUpCont = new VBox(custTool, exitConfLblCont, exitBtnsCont);

        //Assigning content to scene
        exitScene = new Scene(exitPopUpCont, 650, 275);

        //Showing scene to stage
        exitStage.setScene(exitScene);
        exitStage.show();

        //Button event handlers
        confExitBtn.setOnAction(e -> {
            Platform.exit();
        });

        cancel.setOnAction(e -> {
            exitStage.close();
            exitStage.setScene(null);
        });

        //CSS Links
        linkStyleSheet("/css/exit-popup-styling.css", exitScene);

        linkStyle(exitPopUpCont, "exit-popup-cont");
        linkStyle(custTool, "cust-toolbar");
        linkStyle(exitPopUpCont, "exit-popup-cont");
        linkStyle(exit, "exit-label");
        linkStyle(custTool, "exit-label-cont");
        linkStyle(exitConfLbl, "exit-conf-label");
        linkStyle(exitConfLblCont, "exit-conf-cont");
        linkStyle(exitBtnsCont, "exit-btns-cont");
        linkStyle(confExitBtn, "conf-exit-btn");
    }

    /*
Creates the scene that populates when create account button is clicked, labels and their respective fields are
written together for readability and ease of maintenance
 */
    private Scene createNewStudentScene(Stage newStudentStage){
        Scene newStudentScene;
        newStudentStage = new Stage(StageStyle.UNDECORATED);

        //Custom title bar
        Label createNew = new Label("Create New Account");
        HBox titleBar = new HBox(createNew);
        dragWindow(titleBar, newStudentStage);

        //Scene Label
        Label studentInfo = new Label("Student Information");
        HBox sceneLblCont = new HBox(studentInfo);

        //Student ID
        Label studentID = new Label("Student ID");
        TextField idTF = new TextField();
        idTF.setPromptText("enter student ID");
        VBox studentIdCont = new VBox(studentID, idTF);

        //First Name
        Label firstName = new Label("First Name");
        TextField firstNameTF = new TextField();
        firstNameTF.setPromptText("enter first name");
        VBox firstNameCont = new VBox(firstName, firstNameTF);

        //Last Name
        Label lastName = new Label("Last Name");
        TextField lastNameTF = new TextField();
        lastNameTF.setPromptText("enter last name");
        VBox lastNameCont = new VBox(lastName, lastNameTF);

        //Email
        Label email = new Label("Email");
        TextField emailTF = new TextField();
        emailTF.setPromptText("enter student email");
        VBox emailCont = new VBox(email, emailTF);

        //Password
        Label password = new Label("Password");
        PasswordField passwordTF = new PasswordField();
        passwordTF.setPromptText("enter password");
        VBox passwordCont = new VBox(password, passwordTF);

        //Confirm Password
        Label confirmPW = new Label("Confirm Password");
        PasswordField confirmPWTF = new PasswordField();
        confirmPWTF.setPromptText("re-enter password");
        VBox confirmPWCont = new VBox(confirmPW, confirmPWTF);

        //Password HBox Container
        VBox pwCont = new VBox(passwordCont, confirmPWCont);

        //Student Classification
        Label classLabel = new Label("Student Classification");
        ObservableList<String> studentClasses = FXCollections.observableArrayList("Freshman", "Sophomore", "Junior",
                "Senior", "Non-Degree Seeking");
        ComboBox<String> classificationCB = new ComboBox<>(studentClasses);
        VBox classificationCont = new VBox(classLabel, classificationCB);

        //GPA
        Label gpaLabel = new Label("Grade Point Average (GPA)");
        TextField gpaTF = new TextField();
        gpaTF.setPromptText("enter GPA");
        VBox gpaCont = new VBox(gpaLabel, gpaTF);

        //Credits Earned
        Label creditsEarnedLabel = new Label("Credits Earned");
        TextField creditsEarnedTF = new TextField();
        creditsEarnedTF.setPromptText("enter credits earned");
        VBox creditsEarnedCont = new VBox(creditsEarnedLabel, creditsEarnedTF);

        //Credits Attempted
        Label creditsAttemptedLabel = new Label("Credits Attempted");
        TextField creditsAttemptedTF = new TextField();
        creditsAttemptedTF.setPromptText("enter credits attempted");
        VBox creditsAttemptCont = new VBox(creditsAttemptedLabel, creditsAttemptedTF);

        //Credits Remaining
        Label creditsRemainingLabel = new Label("Credits Remaining");
        TextField creditsRemainingTF = new TextField();
        creditsRemainingTF.setPromptText("enter credits remaining");
        VBox creditsRemainingCont = new VBox(creditsRemainingLabel, creditsRemainingTF);

        //GPA and credits info container
        VBox creditsAndGPACont = new VBox(gpaCont, creditsEarnedCont, creditsAttemptCont, creditsRemainingCont);

        //Buttons
        Button submitBtn = new Button("Submit");
        Button cancelBtn = new Button("Cancel");

        //Button handlers
        createNewBtnsHandler(submitBtn, cancelBtn, newStudentStage);

        /*
        Containers for the setup of the scene
         */

        //Left hand side of container
        VBox leftHand = new VBox(studentIdCont, firstNameCont, lastNameCont, emailCont, passwordCont, confirmPWCont);

        //Right hand side of createNewStudent
        VBox rightHand = new VBox(gpaCont, creditsEarnedCont, creditsAttemptCont, creditsRemainingCont, classificationCont);

        //

        //Buttons container
        HBox createBtnsCont = new HBox(submitBtn, cancelBtn);

        //All student Info
        HBox studentInfoCont = new HBox(leftHand, rightHand);
        //Scene container

        VBox newStudentSceneCont = new VBox(titleBar, sceneLblCont, studentInfoCont, createBtnsCont);

        //Scene assignment
        newStudentScene = new Scene(newStudentSceneCont, 600, 710);
        newStudentStage.setScene(newStudentScene);
        newStudentStage.show();

        /*
        CSS Links to stylesheet and selectors
         */
        linkStyleSheet("/css/create-new-acct-styling.css", newStudentScene);

        //Buttons

        //Containers
        linkStyle(titleBar, "title-bar");
        linkStyle(sceneLblCont, "scene-lbl-cont");
        linkStyle(createBtnsCont, "btns-cont");
        linkStyle(studentInfo, "student-info-lbl");
        linkStyle(studentInfoCont, "student-info-cont");
        linkStyle(leftHand, "left-hand-cont");
        linkStyle(rightHand, "right-hand-cont");

        //Labels
        //TextField
        linkStyle(gpaTF, "number-tf");
        linkStyle(creditsEarnedTF, "number-tf");
        linkStyle(creditsAttemptedTF, "number-tf");
        linkStyle(creditsRemainingTF, "number-tf");


        return newStudentScene;
    }

    private void loginSceneBtnHandlers(Button login, Button createAcct, Button forgotPW){

        login.setOnAction(e->{

        });

        createAcct.setOnAction(e->{
            createNewStudentScene(newStudentStage);
        });

        forgotPW.setOnAction(e->{

        });
    }

    private void createNewBtnsHandler(Button submit, Button cancel, Stage stage){

        submit.setOnAction(e->{

        });

        cancel.setOnAction(e->{
            Stage cancelEnrollStage = new Stage(StageStyle.UNDECORATED);
            Scene cancelEnrollScene;

            //Window titlebar and Label w/ dragWindow method
            Label createAccount = new Label("Create New Account");
            HBox titleBar = new HBox(createAccount);
            dragWindow(titleBar, cancelEnrollStage);

            //Label
            Label confirmCx = new Label("Are you sure you wish to cancel registration?\nProgress will not be saved.");
            HBox confirmCxLblCont = new HBox(confirmCx);

            //Buttons
            Button cancelEnrollment = new Button("Yes");
            Button dontCancelEnrollment = new Button("No");
            HBox cxEnrollBtns = new HBox(cancelEnrollment, dontCancelEnrollment);

            //Cancel enrollment content container
            VBox cxEnrollCont = new VBox(titleBar, confirmCxLblCont, cxEnrollBtns);

            //Scene assignment
            cancelEnrollScene = new Scene(cxEnrollCont, 600, 200);
            cancelEnrollStage.setScene(cancelEnrollScene);
            cancelEnrollStage.show();


            //Button event handlers
            cancelEnrollment.setOnAction(event->{
                cancelEnrollStage.close();
                stage.close();
            });

            dontCancelEnrollment.setOnAction(event->{
                cancelEnrollStage.close();
            });

            //CSS link
            linkStyleSheet("/css/create-new-acct-styling.css", cancelEnrollScene);

            //Buttons
            //Containers
            linkStyle(titleBar, "title-bar");
            linkStyle(cxEnrollBtns, "btns-cont");
            linkStyle(cxEnrollCont, "cx-enroll-cont");
            linkStyle(cxEnrollBtns, "cx-enroll-btns-cont");
            linkStyle(confirmCxLblCont, "confirm-cx-lbl-cont");
            //Labels
            linkStyle(confirmCx, "confirm-cx-label");
            //
        });
    }

}
