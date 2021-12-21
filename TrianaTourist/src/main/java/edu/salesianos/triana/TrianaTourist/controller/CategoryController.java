package edu.salesianos.triana.TrianaTourist.controller;

import edu.salesianos.triana.TrianaTourist.dto.category.CategoryDtoConverter;
import edu.salesianos.triana.TrianaTourist.dto.category.CreateCategoryDto;
import edu.salesianos.triana.TrianaTourist.dto.category.GetCategoryDto;
import edu.salesianos.triana.TrianaTourist.model.Category;
import edu.salesianos.triana.TrianaTourist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryDtoConverter categoryDtoConverter;

    @GetMapping("/")
    public ResponseEntity<List<Category>> findAll(){ return ResponseEntity.ok().body(categoryService.findAlll());}

    @GetMapping("/{id}")
    public ResponseEntity<GetCategoryDto> findOne(@PathVariable Long id){
        return ResponseEntity.ok().body(categoryDtoConverter.createCategoryToCategoryDTO(categoryService.findById(id).get()));
    }

    @PostMapping("/")
    public ResponseEntity<GetCategoryDto> crear(@Valid @RequestBody CreateCategoryDto c){
        Category category = categoryDtoConverter.createCategoryDtoToCategory(c);
        categoryService.save(category);
        GetCategoryDto dto = categoryDtoConverter.createCategoryToCategoryDTO(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateCategoryDto> editar(@PathVariable("id") Long id,@Valid @RequestBody CreateCategoryDto c){
        categoryService.edit(id,c);
        return ResponseEntity.ok().body(c);
    }
}
