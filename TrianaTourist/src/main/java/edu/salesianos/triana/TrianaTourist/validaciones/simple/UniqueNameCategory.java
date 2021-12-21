package edu.salesianos.triana.TrianaTourist.validaciones.simple;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Constraint(validatedBy = UniqueNameCategoryValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueNameCategory {

    String message() default "Esta categoría está repetida";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};


}
