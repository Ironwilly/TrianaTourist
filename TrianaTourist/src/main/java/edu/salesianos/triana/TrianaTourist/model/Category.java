package edu.salesianos.triana.TrianaTourist.model;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category implements Serializable {

    @Id @GeneratedValue
    private Long id;

    private String name;



    public Category(String name) {
        this.name = name;
    }
}
