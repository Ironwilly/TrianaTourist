package edu.salesianos.triana.TrianaTourist.repos;

import edu.salesianos.triana.TrianaTourist.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByName(String name);
}
