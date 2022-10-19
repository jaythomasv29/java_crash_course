package com.notely.noteApp;

import com.notely.noteApp.exceptions.ErrorResponse;
import com.notely.noteApp.exceptions.UserNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex) {
      return new ResponseEntity<>(new ErrorResponse(Arrays.asList(ex.getMessage())), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
    return new ResponseEntity<>(new ErrorResponse(Arrays.asList(ex.getMessage())), HttpStatus.BAD_REQUEST);
  }
  // validate DataIntegrity to prevent duplicate usernames
  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
    return new ResponseEntity<>(new ErrorResponse(Arrays.asList("Data Integrity Violation: Username already exists in records")), HttpStatus.BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
    List<String> errors = new ArrayList<>();
    for(ObjectError err : e.getBindingResult().getAllErrors()) {
      errors.add(err.getDefaultMessage());
    }
    return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
  }
}
