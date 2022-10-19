package com.notely.noteApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * implement Serializable interface to allow this class to
 * be converted to a Bytestream and sent outside the application or stored in a log
 */
public class UserDto implements Serializable {
  private Long id;

//  @NotBlank(message = "username cannot be blank")
  @Size(min = 6, message = "username must be at least 6 characters")
  private String username;

  @Size(min = 5, message = "password must be at least 5 characters")
//  @NotBlank(message = "password cannot be blank")
  private String password;
  private Set<NoteDto> notes = new HashSet<>();
}
