import com.ltp.gradesubmission.Grade.Grade;
import com.ltp.gradesubmission.Grade.GradeRepository;
import com.ltp.gradesubmission.Grade.GradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//This is a runner class
// @RunWith annotation creates a runner class: A class that runs every unit test nested inside
@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {
//  @Mock to create a mock of the repository
//  Mocks / Mimics the behavior of the data (repository)
  @Mock
  private GradeRepository gradeRepository;

  @InjectMocks  // creates instance of GradeRepository Object
  private GradeService gradeService;

  // when the service calls gradeReposity.getGrades() it should return a list of grades
  @Test
  public void getGradesFromRepoTest() {
    when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
      new Grade("Harry", "Science", "D+"),
      new Grade("James", "Sleeping", "C+"),
      new Grade("Nat", "Coding", "A+"),
      new Grade("Miley", "Fitness", "B+")
    ));
    // Call method to test
    List<Grade> result = gradeService.getGrades();
    // Assert that actual data == expected data
    assertEquals("Harry", result.get(0).getName());
    assertEquals("Sleeping", result.get(1).getSubject());
  }

  // when we are searching for a specific Grade, it will return the correct index
  @Test
  public void gradeIndexTest() {
    // Arrange mock data
    Grade grade = new Grade("James", "Sleeping", "C+");
    when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));

    List<Grade> result = gradeService.getGrades();
    // Call method to test
    int validIndex= gradeService.getStudentIdxById(grade.getId());
    int invalidIndex = gradeService.getStudentIdxById("aaa");
    // Assert
    assertEquals(0, validIndex);
    assertEquals(-1, invalidIndex);
  }

  // when we add a grade, the gradeRepository should correctly store the new grade
  @Test public void addGradeTest() {
    // Mock data
    Grade grade = new Grade("Joe", "Podcasts", "A");
    when(gradeService.submitGrade(grade)).thenReturn(Arrays.asList(grade));
    int gradeRepositorySize = gradeService.getGrades().size();
    // verify that addGrade() gets called
    verify(gradeRepository, times(1)).addGrade(grade);
    assertEquals(1, gradeRepositorySize);
  }

  @Test public void updateGradeTest() {
    Grade grade = new Grade("Bob", "Building", "A+");
    when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
    grade.setSubject("Auto Repair");
    // Call the method
    gradeService.submitGrade(grade);
    // verify that updateGrade() gets called
    verify(gradeRepository, times(1)).updateGrade(0, grade);
  }
}
