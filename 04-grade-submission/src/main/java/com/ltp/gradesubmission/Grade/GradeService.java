package com.ltp.gradesubmission.Grade;

import com.ltp.gradesubmission.Grade.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {
  @Autowired
  GradeRepository gradeRepository;
//  public GradeService(GradeRepository gradeRepository) {
//    this.gradeRepository = gradeRepository;
//  }
  public List<Grade> getGrades() {
    return gradeRepository.getGrades();
  }

  public Grade getGrade(int index) {
    return gradeRepository.getGrade(index);
  }

  public void addGrade(Grade grade) {
    gradeRepository.addGrade(grade);
  }

  public void updateGrade(int index, Grade grade){
    gradeRepository.updateGrade(index, grade);
  }

  public void deleteGrade(int index) {
    gradeRepository.deleteGrade(index);
  }
  public int getStudentIdxById(String id) {
    for(int i = 0; i < getGrades().size(); i++) {
      if(getGrades().get(i).getId().equals(id)){
        return i;
      }
    }
    return -1;
  }

  public List<Grade> submitGrade(Grade grade) {
    int studentIdx = getStudentIdxById(grade.getId());
    if(studentIdx == -1) {
      addGrade(grade);
    } else {
      updateGrade(studentIdx, grade);
    }
    return getGrades();
  }

}
