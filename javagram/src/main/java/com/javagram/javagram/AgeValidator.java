package com.javagram.javagram;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// Validator that implements the Constraints Interface and @Overrides isValid() method
public class AgeValidator implements ConstraintValidator<Age, Date> {

  @Override
  public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
    long diff = new Date().getTime() - date.getTime();
    int age = (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);
    return age >= 18;
  }
}