package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {
}