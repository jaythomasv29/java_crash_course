package com.notely.noteApp.dtos;

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
  private UserDto user;
}
