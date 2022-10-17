package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;

public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    Student updateStudent(Long id, Student student);
    Set<Course> getStudentCourses(Long studentId);
    void deleteStudent(Long id);
    List<Student> getStudents();

}