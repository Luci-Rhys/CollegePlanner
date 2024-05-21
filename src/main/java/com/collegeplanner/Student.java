package com.collegeplanner;

import java.util.ArrayList;

public class Student {

    private int schoolId;
    private String username;
    private String email;
    private String password;
    private String classification;

    private double gradePtAvg;
    private int creditsEarned;
    private int creditsAttempted;
    private ArrayList<Planner> planners;

    public Student(int id, String username, String email, String password, String classification) {
        this.schoolId = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.classification = classification;
    }

    public void createUser(){
    }

    public int getId() {
        return schoolId;
    }

    public void setId(int id) {
        this.schoolId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
