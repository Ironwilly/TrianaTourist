package edu.salesianos.triana.TrianaTourist.services;

import edu.salesianos.triana.TrianaTourist.dto.category.CategoryDtoConverter;
import edu.salesianos.triana.TrianaTourist.dto.category.CreateCategoryDto;
import edu.salesianos.triana.TrianaTourist.errores.excepciones.EntityNotFoundException;
import edu.salesianos.triana.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import edu.salesianos.triana.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import edu.salesianos.triana.TrianaTourist.model.Category;
import edu.salesianos.triana.TrianaTourist.repos.CategoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {



    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;

    public List<Category> findAlll(){

        if( categoryRepository.findAll().isEmpty()){
            throw new ListEntityNotFoundException(Category.class);
        }else{
            return categoryRepository.findAll();
        }
    }

    public Optional<Category> findById(Long id) {
        if (categoryRepository.findById(id).isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Category.class);
        } else {
            return categoryRepository.findById(id);
        }
    }

    public Category save(Category category){;
        categoryRepository.save(category);
        return category;
    }



    public Category edit(Long id, CreateCategoryDto dto){
        Optional<Category> c= categoryRepository.findById(id);

        if(c.isEmpty()){
            throw new EntityNotFoundException(id,Category.class);
        }
        return c.map(nuevo->{
            nuevo.setName(dto.getName());
            categoryRepository.save(nuevo);
            return nuevo;
        }).get();
    }

    public void delete(Long id) {

        if (categoryRepository.findById(id).isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Category.class);
        } else {
            categoryRepository.deleteById(id);;
        }

    }
}
