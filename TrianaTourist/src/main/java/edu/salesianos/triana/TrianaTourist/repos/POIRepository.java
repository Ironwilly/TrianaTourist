package edu.salesianos.triana.TrianaTourist.repos;

import edu.salesianos.triana.TrianaTourist.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface POIRepository extends JpaRepository<POI,Long> {

boolean existsByLocation (String name);


}
