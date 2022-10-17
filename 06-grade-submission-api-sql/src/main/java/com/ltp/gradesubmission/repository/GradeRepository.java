package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Grade;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// Auto generates a bean that inherits methods that CrudRepository exposes
// Every grade entity is identified with a Long (Id)
public interface GradeRepository extends CrudRepository<Grade, Long> {
  Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);
  Optional<List<Grade>> findByCourseId(Long courseId);
  List<Grade> findAllByStudentId(Long id);
  @Transactional
  void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
}