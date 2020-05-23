package com.tracking.annotation.annotationprocessor;

import com.tracking.annotation.validation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> {

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumber.length() >=2 && isValidStart(phoneNumber) && isValidSymbols(phoneNumber);
    }

    private boolean isValidStart(String phoneNumber){
        char start = phoneNumber.charAt(0);
        return Character.isDigit(start) || start == '+';
    }
    private boolean isValidSymbols(String phoneNumber){
        for (int i = 1; i < phoneNumber.length(); i++){
            if (!Character.isDigit(phoneNumber.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
