package br.com.hbsis.hbsis.validator;

import br.com.hbsis.hbsis.annotations.ValidAgeOfTeacher;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeOfTeacherValidator implements ConstraintValidator<ValidAgeOfTeacher, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return (value <= 65) && (value >= 18);
    }
}
