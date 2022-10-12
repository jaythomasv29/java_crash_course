package com.ltp.contacts;

import com.ltp.contacts.exception.ContactNotFoundException;
import com.ltp.contacts.exception.ErrorResponse;
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
public class ApplilcationExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ContactNotFoundException.class)
  public ResponseEntity<Object> handleContactNotFoundException(ContactNotFoundException e) {
    ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(e.getMessage()));
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
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
