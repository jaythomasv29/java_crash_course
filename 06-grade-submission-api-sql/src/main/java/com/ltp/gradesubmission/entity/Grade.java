package com.ltp.gradesubmission.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "grades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    @Id  // primary key specifier
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto_increment
    @Column(name = "id")  // column name
    private Long id;

    @ManyToOne(optional = false) // many grades will be associated to one student
    @JoinColumn(name = "student_id", referencedColumnName = "id")   // foreign key
    private Student student;

    @Column(name = "score", nullable = false)  // column name, not_null
    private String score;

//    public Long getId() {
//        return this.id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getScore() {
//        return this.score;
//    }
//
//    public void setScore(String score) {
//        this.score = score;
//    }

}
