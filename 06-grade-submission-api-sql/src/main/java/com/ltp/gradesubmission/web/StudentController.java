package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/student")

public class StudentController {
  @Autowired
  StudentService studentService;

  @GetMapping("/all")
  public ResponseEntity<List<Student>> getAllStudents() {
    System.out.println("Called all students");
    return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudent(@PathVariable Long id) {
    return new ResponseEntity<Student>(studentService.getStudent(id), HttpStatus.OK);
  }

  @PostMapping("/")
  public ResponseEntity<Student> saveStudent(@RequestBody @Valid Student student) {
    return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody @Valid Student student) {
    return new ResponseEntity<>(studentService.updateStudent(id, student), HttpStatus.OK);
  }

  @GetMapping("/{studentId}/courses")
  public ResponseEntity<Set<Course>> getEnrolledCoursesOfStudent(@PathVariable Long studentId) {
    return new ResponseEntity<>(studentService.getStudentCourses(studentId), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
