package br.com.hbsis.hbsis.annotations;

import br.com.hbsis.hbsis.validator.GradeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GradeValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidGrade {
    String message() default "Nota não Valida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
