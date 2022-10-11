package com.ltp.gradesubmission.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Custom Score Constraint Validator
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ScoreValidator.class)
public @interface Score {
  // must be included when a constraint is created
  String message() default "Invalid Data";
  Class<?>[] groups() default{};
  Class<? extends Payload>[] payload() default{};
}
