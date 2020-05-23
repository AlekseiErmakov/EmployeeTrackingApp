package com.tracking.annotation.validation;

import com.tracking.annotation.annotationprocessor.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface Username {

    String message () default "username is not valid";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};

    int min() default 3;

    int max() default 15;
}
