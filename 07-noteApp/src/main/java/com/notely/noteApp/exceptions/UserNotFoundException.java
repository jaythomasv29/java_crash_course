package com.notely.noteApp.exceptions;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException() { super("Username or password does not exist in our records"); }
}
