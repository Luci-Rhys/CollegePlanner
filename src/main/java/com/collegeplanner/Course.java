package com.collegeplanner;

import java.util.ArrayList;

public class Course {
    private ArrayList<Assignment> courseAssignments;
    private GradeBook gradebook;
    private CourseInfo courseInfo;
    private CourseNotes courseNotes;

    class CourseInfo{
        private String courseName, courseCode;
        private String professorName, professorEmail, professorPhone, profOfficeLocation;
        private String taName, taEmail;
        private int creditHours;
        ArrayList<GradeBook.GradeCategory> gradeBreakdown;

        public CourseInfo(String courseName, String courseCode, String professorName, String professorEmail, String
                          professorPhone, String profOfficeLocation, String taName, String taEmail, int creditHours){

            this.courseName = courseName;
            this.courseCode = courseCode;
            this.professorName = professorName;
            this.professorEmail = professorEmail;
            this.professorPhone = professorPhone;
            this.profOfficeLocation = profOfficeLocation;
            this.taName = taName;
            this.taEmail = taEmail;
            this.creditHours = creditHours;
        }


    }
}
