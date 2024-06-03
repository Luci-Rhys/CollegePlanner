package com.collegeplanner;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Validation{

    public Validation(){
    }

    //Checks if contents of two text fields are equal (case-sensitive)
    public boolean areFieldsEqual(TextField tf1, TextField tf2){
        boolean areFieldsEqual;

        String str1 = tf1.getText();
        String str2 = tf2.getText();

        if(!str1.equals(str2)){
            areFieldsEqual = false;
            invalidInput(tf2);
        }
        else {
            areFieldsEqual = true;
        }

        return areFieldsEqual;
    }

    //Checks if a textfield is empty
    public boolean isFieldEmpty(ArrayList<TextField> textfields, Label errLabel) {
        boolean emptyFieldsExist = false;

        for (TextField tf : textfields) {
            if (tf.getText().isEmpty()) {
                emptyFieldsExist = true;
                invalidInput(tf);
                showLbl(errLabel);
            }
        }

        if(!emptyFieldsExist){
            hideLbl(errLabel);
        }
        return emptyFieldsExist;
    }

    public boolean containsOnlyLetters(TextField tf){
        boolean containsOnlyLetters = false;
        String tfInput = tf.getText();

        if(Pattern.matches("^[a-zA-Z]*$", tfInput)){
            containsOnlyLetters = true;
        }
        else
            invalidInput(tf);

        return containsOnlyLetters;
    }

    //Checks if the user provided email fits valid email format
    public boolean isValidEmail(TextField emailTF, Label errLabel){
        String emailAddress = emailTF.getText();

        boolean isValid = true;

        try{
            InternetAddress email = new InternetAddress(emailAddress);
            email.validate();
        }
        catch (AddressException e){
            isValid = false;
            invalidInput(emailTF);
            showLbl(errLabel);
        }
        return isValid;
    }

    //Method checks if password is equal to or more than 9 characters and does not contain invalid symbols or characters
    public boolean isPasswordValid(PasswordField pf, Label errLabel){
        boolean isPasswordValid = false;
        String password = pf.getText();

        if(password.length() >= 9 && password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*])(?!.*[^\\w~!@#$%^&*]).{9,}$")){
            isPasswordValid = true;
            hideLbl(errLabel);
        }
        else
            invalidInput(pf);
            showLbl(errLabel);

        return isPasswordValid;
    }

    //Checks if the GPA entered is less than/equal to 0.0 and less than/equal to 4.0
    public boolean isValidGPA(TextField gpaTF, Label errLabel){
        String gpaStr = gpaTF.getText();
        double gpa = Double.parseDouble(gpaStr);
        boolean isValidGPA = false;

        if(Pattern.matches("^[0-9.]+$", gpaStr) && gpa >= 0.0 && gpa <= 4.0){
            isValidGPA = true;
            hideLbl(errLabel);
        }
        else
            invalidInput(gpaTF);
            showLbl(errLabel);

        return isValidGPA;
    }


    //Checks if the number of hours earned is below the number of hours attempted
    public boolean isErnUnderAtt(TextField erndHrsTF, TextField attHrsTF){
        int earnedHrs = Integer.parseInt(erndHrsTF.getText());
        int attemptHrs = Integer.parseInt(attHrsTF.getText());

        return earnedHrs <= attemptHrs;
    }

    public boolean isSelectionMade(ComboBox<String> cb){
        boolean isSelectionMade = false;

        if(!cb.getSelectionModel().isEmpty()){
            isSelectionMade = true;
        }
        else
            invalidInput(cb);

        return isSelectionMade;
    }

    private void invalidInput(Node node){
        node.setStyle("-fx-border-color: red;"
                      + "-fx-border-width: 2px;");


    }

    public void validInput(Node node) {
        node.setStyle("");
    }

    public void hideLbl(Label label){
        label.setVisible(false);
    }

    public void showLbl(Label label){
        label.setVisible(true);
    }
}
