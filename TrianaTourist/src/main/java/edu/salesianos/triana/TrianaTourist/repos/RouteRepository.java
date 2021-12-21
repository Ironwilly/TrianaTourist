package edu.salesianos.triana.TrianaTourist.repos;

import edu.salesianos.triana.TrianaTourist.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {

    boolean existsByName(String name);


}
