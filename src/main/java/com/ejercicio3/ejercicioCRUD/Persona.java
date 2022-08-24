package com.ejercicio3.ejercicioCRUD;

import lombok.Data;

import java.io.Serializable;

@Data
public class Persona implements Serializable {
    Integer id;
    String nombre;
    String poblacion;
    Integer edad;

    public Persona(Integer id, String nombre, String poblacion, Integer edad){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.poblacion = poblacion;
    }

}

