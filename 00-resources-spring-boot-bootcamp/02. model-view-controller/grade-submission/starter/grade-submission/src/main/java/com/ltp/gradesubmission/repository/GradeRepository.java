package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.Grade;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class GradeRepository {
  private List<Grade> studentGrades = new ArrayList<>(Arrays.asList(
    new Grade("Harry", "Science", "D+"),
    new Grade("James", "Sleeping", "C+"),
    new Grade("Nat", "Coding", "A+"),
    new Grade("Miley", "Fitness", "B+")
  ));

  public List<Grade> getGrades() {
    return studentGrades;
  }

  public Grade getGrade(int index) {
    return studentGrades.get(index);
  }

  public void addGrade(Grade grade) {
    studentGrades.add(grade);
  }

  public void updateGrade(int index, Grade grade){
    studentGrades.set(index, grade);
  }
}
