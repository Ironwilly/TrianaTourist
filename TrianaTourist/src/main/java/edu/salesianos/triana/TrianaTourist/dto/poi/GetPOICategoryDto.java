package edu.salesianos.triana.TrianaTourist.dto.poi;

import edu.salesianos.triana.TrianaTourist.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GetPOICategoryDto extends GetPOIDto{

    private  Long idCategory;

    private  String nameCategory;

    public GetPOICategoryDto(String name,String location,String description,LocalDate date,
                             Category category,String coverPhoto,String photo2,String nameCategory){

        super(name,location,description,date,category,coverPhoto,photo2,nameCategory);
        this.nameCategory = nameCategory;
    }






}
