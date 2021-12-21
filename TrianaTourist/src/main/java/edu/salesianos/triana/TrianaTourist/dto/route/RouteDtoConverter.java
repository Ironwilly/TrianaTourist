package edu.salesianos.triana.TrianaTourist.dto.route;

import edu.salesianos.triana.TrianaTourist.model.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteDtoConverter {

    public Route createRouteDTOToRoute(CreateRouteDto r){
        return Route.builder()
                .name(r.getName())
                .steps(r.getSteps())
                .build();
    }

    public GetRouteDto createRouteToRouteDTO(Route r){
        return GetRouteDto.builder()
                .id(r.getId())
                .name(r.getName())
                .steps(r.getSteps())
                .build();
    }
}
