package com.company;

public class Teacher extends Person {
    int salary;
    public Teacher(String name, int age, int salary) {
        super(name, age);
        setSalary(salary);
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" + "name=" + super.getName() + "age=" + super.getAge() +
                "salary=" + salary +
                '}';
    }
}
