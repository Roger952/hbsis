package br.com.hbsis.hbsis.annotations;

import br.com.hbsis.hbsis.validator.AgeOfTeacherValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeOfTeacherValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAgeOfTeacher {
    String message() default "Idade não aceitavel";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
