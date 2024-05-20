package com.collegeplanner;

import java.util.ArrayList;

public class GradeBook {
    private ArrayList<Assignment> submittedAssignments;
    private double courseGrade;

    private void updateGrade(Assignment assignment, double pointsReceived) {
        assignment.setPointsEarned(pointsReceived);
    }

    private double calcAssGrade(Assignment assignment){
        double assignmentGrade = 0;

        if(assignment.hasBeenSubmitted()){
            assignmentGrade = (assignment.getPointsEarned())/(assignment.getPointsPossible());
        }

        return assignmentGrade;
    }

    class GradeCategory{

        private String categoryName;
        private double categoryWeight;

        public GradeCategory(String categoryName, double categoryWeight){
            this.categoryName = categoryName;
            this.categoryWeight = categoryWeight;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public double getCategoryWeight() {
            return categoryWeight;
        }

        public void setCategoryWeight(double categoryWeight) {
            this.categoryWeight = categoryWeight;
        }

    }
}
