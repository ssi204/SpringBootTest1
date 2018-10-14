package com.spring.test.Validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = MatchDatesValidator.class)
public @interface MatchDates {
    String message() default "{}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
