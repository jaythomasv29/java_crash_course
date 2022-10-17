package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/grade")
public class GradeController {

  @Autowired
  GradeService gradeService;

    @GetMapping("/all")
    public ResponseEntity<List<Grade>> getGrades() {
      return new ResponseEntity<>(gradeService.getAllGrades(), HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}/course/{courseId}")
  public ResponseEntity<Grade> getGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
      return new ResponseEntity<>(gradeService.getGrade(studentId, courseId), HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Grade>> getCourseGrades(@PathVariable Long courseId) {
      return new ResponseEntity<>(gradeService.getCourseGrades(courseId), HttpStatus.OK);
    }
  @GetMapping("/student/{studentId}")
  public ResponseEntity<List<Grade>> getStudentGrades(@PathVariable Long studentId) {
    return new ResponseEntity<>(gradeService.getStudentGrades(studentId),HttpStatus.OK);
  }

    @PostMapping("/student/{studentId}/course/{courseId}")
  public ResponseEntity<Grade> saveGrade(@RequestBody @Valid Grade grade, @PathVariable Long studentId, @PathVariable Long courseId) {
      return new ResponseEntity<>(gradeService.saveGrade(grade, studentId, courseId), HttpStatus.CREATED);
    }

  @PutMapping("/student/{studentId}/course/{courseId}")
  public ResponseEntity<Grade> updateGrade(@RequestBody @Valid Grade grade, @PathVariable Long studentId, @PathVariable Long courseId) {
    return new ResponseEntity<>(gradeService.updateGrade(grade.getScore(), studentId, courseId), HttpStatus.OK);
  }

  @DeleteMapping("/student/{studentId}/course/{courseId}")
  public ResponseEntity<Grade> deleteGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
    gradeService.deleteGrade(studentId, courseId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
