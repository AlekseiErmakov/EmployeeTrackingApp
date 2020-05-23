package com.tracking.annotation.annotationprocessor;

import com.tracking.annotation.validation.Username;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username, String> {
    private int minLength;
    private int maxLength;

    @Override
    public void initialize(Username constraintAnnotation) {
        minLength = constraintAnnotation.min();
        maxLength = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return !containsIllegal(username) && minLength <= username.length() && maxLength >= username.length();
    }
    private boolean containsIllegal(String username){
        String sub = username.replaceAll("[a-z0-9A-Z]", "");
        return sub.length() > 0;
    }
}
