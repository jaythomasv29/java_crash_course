package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.CourseNotFoundException;
import com.ltp.gradesubmission.exception.GradeNotFoundException;
import com.ltp.gradesubmission.exception.StudentNotEnrolledException;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//@AllArgsConstructor -> Same as autowired to inject gradeRepository, and studentRepository
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    StudentRepository studentRepository;
    
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        return unwrapGrade(grade, studentId, courseId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = StudentServiceImpl.unwrapStudent(studentRepository.findById(studentId), studentId);
        Course course = CourseServiceImpl.unwrapCourse(courseRepository.findById(courseId), courseId);
        if(!student.getCourses().contains(course)) throw new StudentNotEnrolledException(studentId, courseId);
        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
           Grade unwrappedGrade = unwrapGrade(grade, studentId, courseId);
            unwrappedGrade.setScore(score);
            return gradeRepository.save(unwrappedGrade);
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
//        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
//          if(grade.isPresent()) {
//              Grade unwrappedGrade = grade.get();
//              gradeRepository.delete(unwrappedGrade);
//          } else {
//              throw new GradeNotFoundException(studentId, courseId);
//          }
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findAllByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
         Optional<List<Grade>> grades = gradeRepository.findByCourseId(courseId);
         if(grades.isPresent()) {
             return grades.get();
         }
         throw new CourseNotFoundException(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();

    }

    public Grade unwrapGrade(Optional<Grade> entity, Long studentId, Long courseId) {
        if(entity.isPresent()) return entity.get();
        else throw new GradeNotFoundException(studentId, courseId);
    }

}
