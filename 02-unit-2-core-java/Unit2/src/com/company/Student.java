package com.company;

import java.util.ArrayList;

public class Student extends Person {
    // field
    char grade;
    public Student(String name, int age, char grade) {
        super(name, age);
        setGrade(grade);
    }

    public Student() {
        // Default constructor
        this("Default", 0, 'A');
    }


    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        char[] validGrades = {'A', 'B', 'C', 'D', 'F'};

        String grades = "ABCDF";
         if(grades.contains(String.valueOf(grade).toUpperCase())) {
             this.grade = grade;
        } else {
             System.out.println("Grade invalid");
             throw new IllegalArgumentException("Invalid Params for Grade");
         }
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + super.getName() + "age=" + super.getAge() +
                "grade=" + grade +
                '}';
    }
}
