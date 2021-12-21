package edu.salesianos.triana.TrianaTourist.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class POI implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String location;

    @Lob
    private String description;

    @CreatedDate
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String coverPhoto;

    private String photo2;

    private String photo3;


    public void add(Route route){
        route.getSteps().add(this);
    }
    public void delete(Route route){
        route.getSteps().remove(this);
    }
}


