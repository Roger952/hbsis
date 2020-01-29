package br.com.hbsis.hbsis.annotations;

import br.com.hbsis.hbsis.validator.SexValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SexValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSex {
    String message() default "Informação errada do sexo";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
