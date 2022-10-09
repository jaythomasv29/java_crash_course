package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;

import java.util.List;

public class GradeService {
  GradeRepository gradeRepository = new GradeRepository();
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
  public int getStudentIdxById(String id) {
    for(int i = 0; i < getGrades().size(); i++) {
      if(getGrades().get(i).getId().equals(id)){
        return i;
      }
    }
    return -1;
  }


}
