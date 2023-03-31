package edu.escuelait.tienda.controllers;

import edu.escuelait.tienda.domain.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonaRestController {
    ArrayList<Persona> personas = new ArrayList<>(
            List.of(new Persona(1L, "Rafael"),
                    new Persona(2L, "Miguel"),
                    new Persona(3L,"Alvaro"))
    );
    public Persona getPersonaById(Long id){
        return null;
    }
    @GetMapping("/personas")
    public List<Persona> listPersonas(){
        return this.personas;
    }

    public Persona createPersona(Persona persona){
        return null;
    }

    public Persona updatePersona(Persona persona){
        return persona;
    }

    public void deletePersona(Long id){

    }
}
