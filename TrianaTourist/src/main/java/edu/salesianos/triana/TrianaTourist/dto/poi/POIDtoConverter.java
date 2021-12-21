package edu.salesianos.triana.TrianaTourist.dto.poi;

import edu.salesianos.triana.TrianaTourist.model.Category;
import edu.salesianos.triana.TrianaTourist.model.POI;
import edu.salesianos.triana.TrianaTourist.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Component;

@Component
public class POIDtoConverter {

    @Autowired
    private CategoryRepository categoryRepository;

public  GetPOIDto poiToGetPOIDto(POI p){

    return GetPOIDto
            .builder()
            .name(p.getName())
            .location(p.getLocation())
            .description(p.getDescription())
            .date(p.getDate())
            .category(p.getCategory())
            .coverPhoto(p.getCoverPhoto())
            .photo2(p.getPhoto2())
            .build();
}

public POI createPOIDtoPOI (CreatePOIDto p){

    POI result = new POI();


    result.setName(p.getName());
    result.setLocation(p.getLocation());
    result.setDescription(p.getDescription());
    result.setDate(p.getDate());
    result.setCategory(p.getCategory());
    result.setCoverPhoto(p.getCoverPhoto());
    result.setPhoto2(p.getPhoto2());
    result.setPhoto3(p.getPhoto3());

    return result;
}

public GetPOICategoryDto poiToGetPOICategoryDto(POI p, Category c){

    GetPOICategoryDto result = new GetPOICategoryDto();
    result.setName(p.getName());
    result.setLocation(p.getLocation());
    result.setCategory(p.getCategory());
    result.setCoverPhoto(p.getCoverPhoto());
    result.setPhoto2(p.getPhoto2());
    result.setNameCategory(c.getName());

    return result;
}

}
