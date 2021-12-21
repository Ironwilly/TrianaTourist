package edu.salesianos.triana.TrianaTourist.dto.route;

import edu.salesianos.triana.TrianaTourist.model.POI;
import edu.salesianos.triana.TrianaTourist.validaciones.simple.UniqueRoute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRouteDto {

    @NotBlank
    @UniqueRoute
    private String name;

    private List<POI> steps;
}
