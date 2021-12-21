package edu.salesianos.triana.TrianaTourist.validaciones.simple;

import edu.salesianos.triana.TrianaTourist.repos.POIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueLocationValidator implements ConstraintValidator<UniqueLocation,String> {

    @Autowired
    private POIRepository poiRepository;


    @Override
    public void initialize(UniqueLocation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String l, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(l) && !poiRepository.existsByLocation(l);
    }

}
