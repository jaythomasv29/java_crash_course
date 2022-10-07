package com.javagram.javagram;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

import java.util.Date;

public class User {
  // First name validator annotations
  @NotBlank(message = "First name cannot be blank")
  @Size(min = 2, message = "First name is too short")
  private String firstName;

  // Last name validator annotations
  @NotBlank(message = "Last name cannot be blank")
  @Size(min = 2, message = "Last name is too short")
  private String lastName;

  // Username validator annotations
  @NotBlank(message = "Username cannot be blank")
  @Size(min = 7, message = "Username must be at least 7 characters")
  @Username(message = "Enter a valid username (no special characters)")
  private String userName;

  // Email validator annotations
  @NotBlank(message = "Email cannot be blank")
  @Email(message = "Enter a valid email")
  private String email;

  // Date of birth validator annotations
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Past(message = "Date of birth is invalid")
  @Age(message = "You must be at least 18")
  private Date dateOfBirth;

  public User() {
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}
