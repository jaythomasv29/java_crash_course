package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.entity.Student;

public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    public Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
    List<Student> getStudents();
}