package edu.salesianos.triana.TrianaTourist.dto.category;


import edu.salesianos.triana.TrianaTourist.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDtoConverter {


    public Category createCategoryDtoToCategory(CreateCategoryDto c){

        return Category.builder()
                .name(c.getName())
                .build();


    }

    public GetCategoryDto createCategoryToCategoryDTO(Category c){

        return  GetCategoryDto.builder()
                .id(c.getId())
                .name((c.getName()))
                .build();
    }


}
