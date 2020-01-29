package br.com.hbsis.hbsis.validator;

import br.com.hbsis.hbsis.annotations.ValidSex;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SexValidator implements ConstraintValidator<ValidSex, String> {
    @Override
    public void initialize(ValidSex constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("Masc") || value.equals("Fem");
    }
}
