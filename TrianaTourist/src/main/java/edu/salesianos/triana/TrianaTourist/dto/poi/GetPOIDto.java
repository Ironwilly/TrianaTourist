package edu.salesianos.triana.TrianaTourist.dto.poi;


import edu.salesianos.triana.TrianaTourist.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GetPOIDto {



    private String name;

    private String location;

    private String description;

    private LocalDate date;

    private Category category;

    private String coverPhoto;

    private String photo2;


    public GetPOIDto(String name, String location, String description, LocalDate date, Category category, String coverPhoto, String photo2, String nameCategory) {
    }
}
