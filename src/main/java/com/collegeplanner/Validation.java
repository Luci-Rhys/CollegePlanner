package com.collegeplanner;

import javafx.scene.control.TextField;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validation {

    //Checks if contents of two text fields are equal (case-sensitive)
    public boolean areFieldsEqual(TextField tf1, TextField tf2){
        String str1 = tf1.getText();
        String str2 = tf2.getText();

        return str1.equals(str2);
    }

    //Checks if a textfield is empty
    public boolean isFieldEmpty(TextField tf){
        String tfStr = tf.getText();

        return tfStr.isEmpty();
    }


    //Checks if the user provided email fits valid email format
    public boolean isValidEmail(TextField emailTF){
        String emailAddress = emailTF.getText();

        boolean isValid = true;

        try{
            InternetAddress email = new InternetAddress(emailAddress);
            email.validate();
        }
        catch (AddressException e){
            isValid = false;
        }
        return isValid;
    }

    //Method checks if password is equal to or more than 9 characters and does not contain invalid symbols or characters

    //Checks if the GPA entered is less than/equal to 0.0 and less than/equal to 4.0
    public boolean isValidGPA(TextField gpaTF){
        double gpa = (Double.parseDouble(gpaTF.getText()));

        return (gpa >= 0.0 && gpa <= 4.0);
    }

}
