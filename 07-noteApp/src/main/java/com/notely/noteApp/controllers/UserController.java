package com.notely.noteApp.controllers;

import com.notely.noteApp.dtos.UserDto;
import com.notely.noteApp.entities.User;
import com.notely.noteApp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
  private UserService userService;
  private PasswordEncoder passwordEncoder;

  @PostMapping("/register")
  public ResponseEntity<User> registerUser(@RequestBody @Valid UserDto userDto) {
    // hash password and set to userDto
    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
    return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<User> loginUser(@RequestBody @Valid UserDto userDto) {
    return new ResponseEntity<>(userService.loginUser(userDto), HttpStatus.OK);
  }

}
