package edu.salesianos.triana.TrianaTourist.services;

import edu.salesianos.triana.TrianaTourist.dto.route.CreateRouteDto;
import edu.salesianos.triana.TrianaTourist.dto.route.RouteDtoConverter;
import edu.salesianos.triana.TrianaTourist.errores.excepciones.EntityNotFoundException;
import edu.salesianos.triana.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import edu.salesianos.triana.TrianaTourist.model.Route;
import edu.salesianos.triana.TrianaTourist.repos.RouteRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteDtoConverter routeDtoConverter;


    public List<Route> findAll(){
        if( routeRepository.findAll().isEmpty()) {
            throw new ListEntityNotFoundException(RouteService.class);
        }else{
            return routeRepository.findAll();
        }
    }

    public Optional<Route> findById(Long id){
        if( routeRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException(id,Route.class);
        }else{
            return this.routeRepository.findById(id);
        }
    }

    public Route save(CreateRouteDto r){
        Route route= routeDtoConverter.createRouteDTOToRoute(r);
        routeRepository.save(route);
        return route;
    }


    public void deleteById(Long id){
        if(routeRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException(id,Route.class);
        }else{
            routeRepository.deleteById(id);
        }
    }

    public Route edit (Long id, CreateRouteDto c){
        Optional<Route> r =routeRepository.findById(id);

        if(r.isEmpty()){
            throw new EntityNotFoundException(id, Route.class);
        }
        return r.map(n->{
            n.setName(c.getName());
            n.setSteps(c.getSteps());
            routeRepository.save(n);
            return n;
        }).get();

    }

}
