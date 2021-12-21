package edu.salesianos.triana.TrianaTourist.validaciones.simple;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Constraint(validatedBy = UniqueRouteValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueRoute {

    String message() default "Esta ruta está repetida";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}
