package edu.salesianos.triana.TrianaTourist.validaciones.simple;

import edu.salesianos.triana.TrianaTourist.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameCategoryValidator implements ConstraintValidator<UniqueNameCategory,String> {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void initialize(UniqueNameCategory constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String c, ConstraintValidatorContext constraintValidatorContext){
    return StringUtils.hasText(c) && !categoryRepository.existsByName(c);
    }
}
