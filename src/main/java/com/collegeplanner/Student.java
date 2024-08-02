package com.collegeplanner;

import java.util.ArrayList;

public class Student {

    private String schoolId;
    private String firstName, lastName, email, password, classification;
    private double gpa;
    private int creditsEarned, creditsAttempted, creditsRemaining;
    private ArrayList<Planner> planners;

    public Student(String id, String firstName, String lastName, String email, String password,
                   String classification, double gpa, int creditsEarned, int creditsAttempted, int creditsRemaining,
                   ArrayList<Planner> planners) {

        this.schoolId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.classification = classification;
        this.gpa = gpa;
        this.creditsEarned = creditsEarned;
        this.creditsAttempted = creditsAttempted;
        this.creditsRemaining = creditsRemaining;
        this.planners = planners;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getCreditsEarned() {
        return creditsEarned;
    }

    public void setCreditsEarned(int creditsEarned) {
        this.creditsEarned = creditsEarned;
    }

    public int getCreditsAttempted() {
        return creditsAttempted;
    }

    public void setCreditsAttempted(int creditsAttempted) {
        this.creditsAttempted = creditsAttempted;
    }

    public int getCreditsRemaining() {
        return creditsRemaining;
    }

    public void setCreditsRemaining(int creditsRemaining) {
        this.creditsRemaining = creditsRemaining;
    }

    public ArrayList<Planner> getPlanners() {
        return planners;
    }

    public void setPlanners(ArrayList<Planner> planners) {
        this.planners = planners;
    }
}
