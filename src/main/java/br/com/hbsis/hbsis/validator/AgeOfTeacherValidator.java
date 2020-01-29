package br.com.hbsis.hbsis.validator;

import br.com.hbsis.hbsis.annotations.AgeOfTeacherValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeOfTeacherValidator implements ConstraintValidator<AgeOfTeacherValidate, Integer> {
    @Override
    public void initialize(AgeOfTeacherValidate constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return (value <= 65) && (value >= 18);
    }
}
