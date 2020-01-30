package br.com.hbsis.hbsis.validator;

import br.com.hbsis.hbsis.annotations.ValidPhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements
        ConstraintValidator<ValidPhoneNumber, String> {

    @Override
    public void initialize(ValidPhoneNumber contactNumber) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext constraintValidatorContext) {
        return contactField != null
                && (contactField.matches("(\\(\\d{2}\\)\\s)(\\d{4,5}-\\d{4})"));
    }

}