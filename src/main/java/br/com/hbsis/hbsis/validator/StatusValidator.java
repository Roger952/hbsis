package br.com.hbsis.hbsis.validator;

import br.com.hbsis.hbsis.annotations.ValidStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusValidator implements ConstraintValidator<ValidStatus, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("Ativo") || value.equals("Finalizado") || value.equals("Aguardando Correção") || value.isEmpty();
    }
}
