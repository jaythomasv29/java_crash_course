package com.notely.noteApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notely.noteApp.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

//  @NotNull(message = "username cannot be blank")
//  @NotBlank(message = "username cannot be blank")
  @Column(unique = true, nullable = false)
  private String username;

  @JsonIgnore
//  @NotNull(message = "password cannot be blank")
//  @NotBlank(message = "password cannot be blank")
  @Column(nullable = false)
  private String password;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private Set<Note> notes = new HashSet<>();

  public User(UserDto userDto) {
    this.setUsername(userDto.getUsername());
    this.setPassword(userDto.getPassword());
  }
}
