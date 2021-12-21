package edu.salesianos.triana.TrianaTourist.services;


import edu.salesianos.triana.TrianaTourist.dto.poi.CreatePOIDto;
import edu.salesianos.triana.TrianaTourist.dto.poi.POIDtoConverter;
import edu.salesianos.triana.TrianaTourist.errores.excepciones.EntityNotFoundException;
import edu.salesianos.triana.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import edu.salesianos.triana.TrianaTourist.model.POI;
import edu.salesianos.triana.TrianaTourist.repos.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class POIService {

    private final POIRepository poiRepository;
    private final POIDtoConverter poiDtoConverter;
    private final CategoryService categoryService;


    public List<POI> findAll(){

        if (poiRepository.findAll().isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);
        }else{
            return poiRepository.findAll();
        }
    }

    public Optional<POI> findById(Long id){
        if(poiRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException(id,POI.class);
        }else{
            return this.poiRepository.findById(id);
        }
    }

    public POI save(POI poi){
        poiRepository.save(poi);
        return poi;
    }


    public void deleteById(Long id){
        if (poiRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException(id,POI.class);
        }else{
            poiRepository.deleteById(id);
        }
    }

    public POI edit(Long id, CreatePOIDto poi){
        Optional<POI> p= poiRepository.findById(id);

        if(p.isEmpty()){
            throw new EntityNotFoundException(id,POI.class);
        }
        return p.map(n->{
            n.setName(poi.getName());
            n.setDescription(poi.getDescription());
            n.setLocation(poi.getLocation());
            n.setCoverPhoto(poi.getCoverPhoto());
            n.setPhoto2(poi.getPhoto2());
            n.setPhoto3(poi.getPhoto3());
            poiRepository.save(n);
            return n;
        }).get();
    }
}
