package edu.salesianos.triana.TrianaTourist.dto.route;

import edu.salesianos.triana.TrianaTourist.model.POI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetRouteDto {

    private Long id;

    private String name;

    private List<POI> steps;
}
