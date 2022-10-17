package com.ltp.gradesubmission;

import com.ltp.gradesubmission.exception.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({CourseNotFoundException.class, GradeNotFoundException.class, StudentNotFoundException.class, StudentNotEnrolledException.class})
  public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex) {
    return new ResponseEntity<>(new ErrorResponse(Arrays.asList(ex.getMessage())), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(EmptyResultDataAccessException.class)
  public ResponseEntity<Object> handleDataAccessException(EmptyResultDataAccessException ex) {
    return new ResponseEntity<>(new ErrorResponse(Arrays.asList("Cannot delete non-existing resource")), HttpStatus.NOT_FOUND);
  }

  //  Attempting to save the same grade twice throws a DataIntegrityViolationException
  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
    return new ResponseEntity<>(new ErrorResponse(Arrays.asList("Data Integrity Violation: we cannot process your duplicate request")), HttpStatus.BAD_REQUEST);
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
