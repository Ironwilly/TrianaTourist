package edu.salesianos.triana.TrianaTourist.controller;


import edu.salesianos.triana.TrianaTourist.dto.poi.CreatePOIDto;
import edu.salesianos.triana.TrianaTourist.dto.route.CreateRouteDto;
import edu.salesianos.triana.TrianaTourist.dto.route.GetRouteDto;
import edu.salesianos.triana.TrianaTourist.dto.route.RouteDtoConverter;
import edu.salesianos.triana.TrianaTourist.model.POI;
import edu.salesianos.triana.TrianaTourist.model.Route;
import edu.salesianos.triana.TrianaTourist.services.POIService;
import edu.salesianos.triana.TrianaTourist.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {


    private final RouteService routeService;
    private final RouteDtoConverter routeDtoConverter;
    private final POIService poiService;


    @GetMapping("/")
    public ResponseEntity<List<Route>> findAll(){return ResponseEntity.ok().body(routeService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<GetRouteDto> findById(@PathVariable Long id){
        Route r= routeService.findById(id).get();
        return ResponseEntity.ok().body(routeDtoConverter.createRouteToRouteDTO(r));
    }

    @PostMapping("/")
    public ResponseEntity<CreateRouteDto> crear(@Valid @RequestBody CreateRouteDto r){
        routeService.save(r);
        return ResponseEntity.status(HttpStatus.CREATED).body(r);
    }


    @PostMapping("/{id}/poi/{id2}")
    public ResponseEntity<GetRouteDto> añadirPOI(@Valid @PathVariable("id") Long id,@PathVariable("id2") Long id2){
        Route r = routeService.findById(id).get();
        POI p= poiService.findById(id2).get();
        p.add(r);
        poiService.save(p);
        return ResponseEntity.ok().body(routeDtoConverter.createRouteToRouteDTO(r));
    }

    @DeleteMapping("/{id}/poi/{id2}")
    public ResponseEntity<GetRouteDto> eliminarPOI(@Valid @PathVariable("id") Long id,@PathVariable("id2") Long id2){
        Route r = routeService.findById(id).get();
        POI p= poiService.findById(id2).get();
        p.delete(r);
        poiService.save(p);
        return ResponseEntity.ok().body(routeDtoConverter.createRouteToRouteDTO(r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        routeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateRouteDto> edit(@PathVariable Long id, @RequestBody CreateRouteDto dto){
        routeService.edit(id,dto);
        return ResponseEntity.ok().body(dto);
    }


}
