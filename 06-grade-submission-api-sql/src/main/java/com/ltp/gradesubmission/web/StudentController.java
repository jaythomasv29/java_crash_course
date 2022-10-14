package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {
  @GetMapping("/all")
  public ResponseEntity<Student> getAllStudents() {
    System.out.println("Get all students");
    return new ResponseEntity<Student>(HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudent(@PathVariable Long id) {
    System.out.println(id);
    return new ResponseEntity<Student>(HttpStatus.OK);
  }

  @PostMapping("/")
  public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
    return new ResponseEntity<>(student, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
    System.out.println(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
