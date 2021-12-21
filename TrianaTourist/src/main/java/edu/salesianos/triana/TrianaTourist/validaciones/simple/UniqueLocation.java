package edu.salesianos.triana.TrianaTourist.validaciones.simple;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniqueLocationValidator.class)
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)


public @interface UniqueLocation {

    String message() default "Ya está en uso esta localización";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
