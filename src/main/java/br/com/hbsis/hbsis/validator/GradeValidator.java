package br.com.hbsis.hbsis.validator;

import br.com.hbsis.hbsis.annotations.ValidGrade;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GradeValidator implements ConstraintValidator<ValidGrade, Double> {
    @Override
    public void initialize(ValidGrade constraintAnnotation) {

    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return value <= 10;
    }
}
