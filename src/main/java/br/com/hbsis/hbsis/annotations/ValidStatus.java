package br.com.hbsis.hbsis.annotations;


import br.com.hbsis.hbsis.validator.StatusValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StatusValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStatus {
    String message() default "Status Inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
