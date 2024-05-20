package com.collegeplanner;

import java.time.LocalDate;

public class Assignment {

    //Declared variables
    private String assignmentName;
    private LocalDate submitDate, dueDate;
    private double pointsEarned, pointsPossible, assignmentGrade;

    private boolean beenSubmitted, submittedLate;

    public Assignment(String assignmentName, LocalDate submitDate, LocalDate dueDate, double pointsEarned,
                      double pointsPossible, double assignmentGrade, boolean beenSubmitted, boolean submittedLate) {
        this.assignmentName = assignmentName;
        this.submitDate = submitDate;
        this.dueDate = dueDate;
        this.pointsEarned = pointsEarned;
        this.pointsPossible = pointsPossible;
        this.assignmentGrade = assignmentGrade;
        this.beenSubmitted = beenSubmitted;
        this.submittedLate = submittedLate;
    }

    //assignmentName getter
    public String getAssignmentName() {
        return assignmentName;
    }

    //assignmentName setter
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    //submitDate getter
    public LocalDate getSubmitDate() {
        return submitDate;
    }

    //submitDate setter
    public void setSubmitDate(LocalDate submitDate) {
        this.submitDate = submitDate;
    }

    //dueDate getter
    public LocalDate getDueDate() {
        return dueDate;
    }

    //dueDate setter
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    //pointsEarned getter
    public double getPointsEarned() {
        return pointsEarned;
    }

    //pointsEarned setter
    public void setPointsEarned(double pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    //pointsPossible getter
    public double getPointsPossible() {
        return pointsPossible;
    }

    //pointsPossible setter
    public void setPointsPossible(double pointsPossible) {
        this.pointsPossible = pointsPossible;
    }

    public boolean hasBeenSubmitted() {
        return beenSubmitted;
    }

    public void setBeenSubmitted(boolean beenSubmitted) {
        this.beenSubmitted = beenSubmitted;
    }

    public boolean isSubmittedLate() {
        if(submitDate.isAfter(dueDate)){
            return true;
        }
        return submittedLate;
    }

    public void setSubmittedLate(boolean submittedLate) {
        this.submittedLate = submittedLate;
    }
}
