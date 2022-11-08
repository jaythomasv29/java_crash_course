package com.notely.noteApp.exceptions;

public class NoteNotFoundException extends RuntimeException {
  public NoteNotFoundException(Long id) {
    super("Note does not exist with the id of " + id);
  }
}
