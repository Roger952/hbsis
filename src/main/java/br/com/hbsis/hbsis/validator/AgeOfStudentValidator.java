package br.com.hbsis.hbsis.validator;

import br.com.hbsis.hbsis.annotations.ValidAgeOfStudent;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeOfStudentValidator implements ConstraintValidator<ValidAgeOfStudent, Integer> {


    @Override
    public void initialize(ValidAgeOfStudent constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return (value <= 25) && (value >= 2);
    }
}
