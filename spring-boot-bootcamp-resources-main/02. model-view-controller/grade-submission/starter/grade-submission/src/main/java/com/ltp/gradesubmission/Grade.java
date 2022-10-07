package com.ltp.gradesubmission;

import java.util.UUID;

// POJO: plain old java object;
public class Grade {
    private String id;
    private String name;
    private String subject;
    private String score;


    public Grade() {
        this.id = UUID.randomUUID().toString();
    }

    public Grade(String name, String subject, String score) {
        this();
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getScore() {
        return this.score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Grade{" +
          "id='" + id + '\'' +
          ", name='" + name + '\'' +
          ", subject='" + subject + '\'' +
          ", score='" + score + '\'' +
          '}';
    }

    public void setScore(String score) {
        this.score = score;
    }
}
