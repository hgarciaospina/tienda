package edu.escuelait.tienda.controllers;

import edu.escuelait.tienda.domain.Persona;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("personas/{id}")
    public Persona getPersonaById(@PathVariable Long id){

        for (Persona persona: personas) {
            if (persona.getId().equals(id)) {
                return persona;
            }
        }
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

    @DeleteMapping("/personas/{id}")
    public void deletePersona(Long id){

        for (Persona persona: personas) {
            if (persona.getId().equals(id)) {
                this.personas.remove(persona);
            }
        }
    }
}
