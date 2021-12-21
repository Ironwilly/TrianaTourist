package edu.salesianos.triana.TrianaTourist.dto.poi;


import edu.salesianos.triana.TrianaTourist.model.Category;
import edu.salesianos.triana.TrianaTourist.validaciones.simple.UniqueLocation;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePOIDto {


    @NotBlank
    private String name;
    @UniqueLocation
    private String location;

    private String description;

    private LocalDate date;

    private Category category;

    @URL
    @NotBlank
    private String coverPhoto;
    @URL
    private String photo2;
    @URL
    private String photo3;
}
