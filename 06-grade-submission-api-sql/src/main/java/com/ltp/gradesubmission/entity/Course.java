package com.ltp.gradesubmission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courses", uniqueConstraints = {
  @UniqueConstraint(columnNames = {"code"})
})
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto generated primary key that auto inccrements
    private Long id;

    @Column(name = "subject")
    @NotBlank(message = "Subject cannot be blank")
    @NonNull
    private String subject;

    @Column(name = "code", nullable = false, unique = true)
    @NotBlank(message = "Course code cannot be blank")
    @NonNull  // performs validation which is done inside the bean (before the persistence cycle)
    private String code;

    @Column(name = "description", nullable = false)
    @NotBlank(message = "description cannot be blank")
    @NonNull
    private String description;

    @JsonIgnore // ignore field to be part of JSON when serialization occurs
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Grade> grades;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
      name="course_student",
      joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
    )
    private Set<Student> students;



//    public Long getId() {
//        return this.id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getSubject() {
//        return this.subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getDescription() {
//        return this.description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

}
