package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


    @Override
    public Student getStudent(Long id) {
        printGrades(studentRepository.findById(id).get());
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
         return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        student.setId(id);
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    void printGrades(Student student) {
        for(Grade grade : student.getGrades()) {
            System.out.println(grade.getScore());
        }
    }

}