package edu.salesianos.triana.TrianaTourist.controller;

import edu.salesianos.triana.TrianaTourist.dto.poi.CreatePOIDto;
import edu.salesianos.triana.TrianaTourist.dto.poi.GetPOIDto;
import edu.salesianos.triana.TrianaTourist.dto.poi.POIDtoConverter;
import edu.salesianos.triana.TrianaTourist.model.POI;
import edu.salesianos.triana.TrianaTourist.services.CategoryService;
import edu.salesianos.triana.TrianaTourist.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/poi")
@RequiredArgsConstructor
public class POIController {

    private final POIService poiService;
    private final POIDtoConverter poiDtoConverter;
    private final CategoryService categoryService;


    @GetMapping("/")
    public ResponseEntity<List<POI>> findAll(){return ResponseEntity.ok().body(poiService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<GetPOIDto> findOne(@PathVariable Long id){
        Optional<POI> p= poiService.findById(id);
        return ResponseEntity.ok().body(poiDtoConverter.poiToGetPOIDto(p.get()));
    }

    @PostMapping("/")
    public ResponseEntity<CreatePOIDto> crear(@Valid @RequestBody CreatePOIDto c){
        POI poi = poiDtoConverter.createPOIDtoPOI(c);
        poiService.save(poi);
        return ResponseEntity.ok().body(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreatePOIDto> edit(@PathVariable Long id, @Valid @RequestBody CreatePOIDto c){
        poiService.edit(id, c);
        return ResponseEntity.ok().body(c);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        poiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }





}
