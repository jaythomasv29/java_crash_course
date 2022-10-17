package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.CourseNotFoundException;
import com.ltp.gradesubmission.exception.StudentNotFoundException;
import com.ltp.gradesubmission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return unwrapStudent(student, id);
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
    public Set<Course> getStudentCourses(Long studentId) {
        Student student = getStudent(studentId);
        return student.getCourses();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    static Student unwrapStudent(Optional<Student> studentEntity, Long id) {
        if(studentEntity.isPresent()) return studentEntity.get();
        else throw new StudentNotFoundException(id);
    }

}