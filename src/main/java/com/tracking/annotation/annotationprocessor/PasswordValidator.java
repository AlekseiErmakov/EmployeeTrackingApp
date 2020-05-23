package com.tracking.annotation.annotationprocessor;

import com.tracking.annotation.validation.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    private int minLength;
    private int maxLength;

    @Override
    public void initialize(Password constraintAnnotation) {
        minLength = constraintAnnotation.min();
        maxLength = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return containsLowLetter(password) && containsUpLetter(password)
                && containsNum(password) && !containsIllegal(password) &&
                minLength <= password.length() && maxLength >= password.length();
    }

    private boolean containsLowLetter(String password) {
        String sub = password.replaceAll("[^a-z]", "");
        return sub.length() > 0;
    }

    private boolean containsUpLetter(String password) {
        String sub = password.replaceAll("[^A-Z]]", "");
        return sub.length() > 0;
    }

    private boolean containsNum(String password) {
        String sub = password.replaceAll("[^0-9]", "");
        return sub.length() > 0;
    }

    private boolean containsIllegal(String password) {
        String sub = password.replaceAll("[^0-9a-zA-Z]", "");
        return sub.length() > 0;
    }
}
