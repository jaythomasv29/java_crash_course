package com.ltp.gradesubmission;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

// POJO: plain old java object;
public class Grade {
    private String id;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Subject cannot be blank")
    private String subject;
    // Custom constraint annotation
    @Score(message = "Score must be a letter grade")
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