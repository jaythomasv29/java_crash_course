package com.ltp.gradesubmission.exception;

public class StudentNotEnrolledException extends RuntimeException{
  public StudentNotEnrolledException(Long studentId, Long courseId) {
    super("Cannot issue grade for the student with student id: '" + studentId + "' because they are not enrolled in course with course id: '" + courseId + "'");
  }

}
