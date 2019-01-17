package com.spring.hibernate.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefix;

   public void initialize(CourseCode courseCode) {
       coursePrefix = courseCode.value();
   }

   public boolean isValid(String code, ConstraintValidatorContext context) {
       if(code != null) {
           for (String prefix : coursePrefix) {
               if(code.startsWith(prefix)) {
                   return true;
               }
           }
           return false;
       }
       return true;
   }
}
