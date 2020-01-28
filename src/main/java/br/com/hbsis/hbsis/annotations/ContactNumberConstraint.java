package br.com.hbsis.hbsis.annotations;


import br.com.hbsis.hbsis.validator.ContactNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactNumberConstraint {

    String message() default "Telefone invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}