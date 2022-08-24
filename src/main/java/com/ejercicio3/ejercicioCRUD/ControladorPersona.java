package com.ejercicio3.ejercicioCRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorPersona {

    @Autowired
    List<Persona> listaPersonas;


    @PostMapping("persona/crear")
    public String creaPersona(@RequestParam Integer id, String nombre, Integer edad, String poblacion) {
        if (id != null && nombre != null && edad != null && poblacion != null) {
            if (listaPersonas.size() == 0) {
                Persona p = new Persona(id, nombre, poblacion, edad);
                listaPersonas.add(p);
                System.out.println("creando persona");
                return "Persona creada correctamente \n" + listaPersonas.toString();

            } else {
                for (int i = 0; i < listaPersonas.size(); i++) {
                    if (listaPersonas.get(i).getId() != id) {

                        Persona p = new Persona(id, nombre, poblacion, edad);
                        listaPersonas.add(p);
                        System.out.println("creando persona...");
                        return "Persona creada correctamente \n" + listaPersonas.toString();
                    }

                    return "La id pertenece a otra persona";
                }
            }
        }
        return "Hay campos sin rellenar";
    }


        @PutMapping("persona/{id}")
        public String editaPersona(@RequestParam Integer id, String nombre, String poblacion, Integer edad) {
            if (id != null && nombre != null && edad != null && poblacion != null) {
                for (int i = 0; i < listaPersonas.size(); i++) {
                    if (listaPersonas.get(i).getId() == id) {
                        listaPersonas.get(i).setNombre(nombre);
                        listaPersonas.get(i).setEdad(edad);
                        listaPersonas.get(i).setPoblacion(poblacion);

                        return "Persona editada correctamente. \n" + listaPersonas.toString();
                    }
                    return "La id proporcionada no pertenece a ninguna persona.";
                }
            }
            return "Algunos campos no están rellenos";
        }


        @RequestMapping(value = "persona/{id}",method = RequestMethod.DELETE)
        public String borraPersona(@RequestParam Integer id) {
            if (id != null) {
                for (int i = 0; i < listaPersonas.size(); i++) {
                    if (listaPersonas.get(i).getId() == id) {
                        listaPersonas.remove(i);

                        return "Persona borrada correctamente. \n" + listaPersonas.toString();
                    }
                }
                return "La id proporcionada no pertenece a ninguna persona.";
            }
            return "Algunos campos no están rellenos";
        }

        @GetMapping("persona/{id}")
        public String muestraPersona(@RequestParam Integer id) {
            if (id != null) {
                for (int i = 0; i < listaPersonas.size(); i++) {
                    if (listaPersonas.get(i).getId() == id) {

                        return "ID: " + listaPersonas.get(i).getId() + " Nombre: " + listaPersonas.get(i).getNombre() + " Edad: " + listaPersonas.get(i).getEdad() + " Población: " + listaPersonas.get(i).getPoblacion();
                    }
                    return "La id proporcionada no pertenece a ninguna persona.";
                }
            }
            return "Algunos campos no están rellenos";
        }








}
