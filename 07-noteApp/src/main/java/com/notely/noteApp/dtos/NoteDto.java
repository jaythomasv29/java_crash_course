package com.notely.noteApp.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notely.noteApp.entities.Note;
import com.notely.noteApp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto implements Serializable {
  private Long id;
  private String body;
  @JsonIgnore
  private User user;

  public NoteDto(Note note) {
    this.setId(note.getId());
    this.setBody(note.getBody());
//    this.setUser(note.getUser());
  }
}
