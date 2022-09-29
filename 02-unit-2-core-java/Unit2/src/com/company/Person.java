package com.company;

class Person implements Comparable<Person> {
    // private fields to restrict access
    private String name;
    private int age;

    public Person(String name, int age) {
        if(name == null || name.isBlank() || age < 0)  throw new IllegalArgumentException("Invalid Params for Person");
        this.name = name;
        this.age = age;
    }

    // default constructor
    public Person() {
        this("JohnDoe", 99);
    }
    // getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }


    public void setAge(int age) {
        // only modify age if value is positive integer
        if(age <= 0) {
            System.out.println("Invalid age");
            throw new IllegalArgumentException("Invalid Params for Person");
        } else {
            this.age = age;
        }
    }

    public void introduce() {
        System.out.println("Hi, my name is " + name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.getAge() > o.getAge()) {
            return -1;
        } else if (this.getAge() < o.getAge()) {
            return 1;
        } else {
            return 0;
        }
    }
}