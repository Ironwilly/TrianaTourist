package edu.salesianos.triana.TrianaTourist.errores.excepciones;

import javax.persistence.EntityNotFoundException;

public class ListEntityNotFoundException extends EntityNotFoundException{

    public ListEntityNotFoundException(Class clazz){
        super(String.format("No se pueden encontrar del tipo %s  ",clazz.getName()));


    }
}
