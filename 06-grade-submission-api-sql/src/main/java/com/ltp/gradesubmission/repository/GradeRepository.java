package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Auto generates a bean that inherits methods that CrudRepository exposes
// Every grade entity is identified with a Long (Id)
public interface GradeRepository extends CrudRepository<Grade, Long> {
  Grade findByStudentId(Long id);
  List<Grade> findAllByStudentId(Long id);
}