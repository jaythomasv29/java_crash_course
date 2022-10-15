package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Student;
import org.springframework.data.repository.CrudRepository;

// Auto generates a bean that inherits methods that CrudRepository exposes
public interface StudentRepository extends CrudRepository<Student, Long> {
}