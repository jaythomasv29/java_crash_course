package com.ltp.gradesubmission.Staff;

public class Staff {
    private String name;
    private int age;
    private String role;
    private double wage;
    private double hoursWorked;

    public Staff(String name, int age, String role, double wage, double hoursWorked) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.wage = wage;
        this.hoursWorked = hoursWorked;

    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
