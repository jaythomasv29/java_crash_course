package com.notely.noteApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.notely.noteApp.dtos.NoteDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(columnDefinition = "text")
  private String body;

  @ManyToOne
  @JsonBackReference
  private User user;

  public Note(NoteDto noteDto) {

  }
}
