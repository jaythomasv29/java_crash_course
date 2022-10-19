package com.ltp.gradesubmission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "students")
/*
Getters, Setters, & Constructors created with lombok mvn package
 */
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

public class Student {
    @Id  // primary key, unique identifier
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @Past(message = "The birth date must be in the past")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grades;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
      name="course_student",
      joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private Set<Course> courses;

}
