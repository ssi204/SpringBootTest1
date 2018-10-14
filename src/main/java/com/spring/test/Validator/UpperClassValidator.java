package com.spring.test.Validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UpperClassValidator implements ConstraintValidator<UpperCase,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        String s1= s.toUpperCase();
        return s.equals(s1);
    }
}
