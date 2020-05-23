package com.tracking.annotation.validation;

import com.tracking.annotation.annotationprocessor.PhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
@Documented
public @interface PhoneNumber {

    String message() default "phone number is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
