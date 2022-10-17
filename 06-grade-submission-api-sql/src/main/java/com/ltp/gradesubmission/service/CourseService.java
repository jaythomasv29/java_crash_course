package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Set;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface CourseService {

    Course getCourse(Long id);
    Course saveCourse(Course course);
    Course updateCourse(Long id, Course course);
    void deleteCourse(Long id);
    Course addStudentToCourse(Long studentId, Long courseId);
    Set<Student> getEnrolledStudents(Long courseId);
    List<Course> getCourses();
}