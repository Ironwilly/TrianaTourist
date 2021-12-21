package edu.salesianos.triana.TrianaTourist.validaciones.multiple;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Constraint(validatedBy =  NoRepeatPhotoValidator.class)
public @interface NoRepeatPhoto {


    String message() default "Las fotos no pueden tener la misma url";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String coverPhoto();
    String photo2();
    String photo3();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        NoRepeatPhoto[] value();
    }
}
