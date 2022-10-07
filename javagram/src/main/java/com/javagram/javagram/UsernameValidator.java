package com.javagram.javagram;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator implements ConstraintValidator<Username, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    Pattern pattern = Pattern.compile("[^a-z0-9 ]");
    Matcher matcher = pattern.matcher(value);
    return !matcher.find();

  }
}
