package edu.salesianos.triana.TrianaTourist.dto.category;


import edu.salesianos.triana.TrianaTourist.validaciones.simple.UniqueNameCategory;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCategoryDto {

    private Long id;
    @NotNull
    @NotBlank
    @UniqueNameCategory
    private String name;


}
