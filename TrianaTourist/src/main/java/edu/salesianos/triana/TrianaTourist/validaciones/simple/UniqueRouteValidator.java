package edu.salesianos.triana.TrianaTourist.validaciones.simple;

import edu.salesianos.triana.TrianaTourist.repos.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueRouteValidator implements ConstraintValidator<UniqueRoute,String> {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public void initialize(UniqueRoute constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !routeRepository.existsByName(s);
    }

}
