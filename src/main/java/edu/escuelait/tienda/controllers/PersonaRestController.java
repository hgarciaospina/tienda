package edu.escuelait.tienda.controllers;

import edu.escuelait.tienda.domain.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaRestController {
    ArrayList<Persona> personas = new ArrayList<>(
        List.of(new Persona(1L, "Rafael", "Celeste"),
                new Persona(2L, "Miguel", "Astuias"),
                new Persona(3L, "Alvaro", "Mejía")
        ));
    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonaById(@PathVariable Long id){

        if(id < 1){
            return ResponseEntity.badRequest().build();
        }
        for (Persona persona: personas) {
                if (persona.getId().equals(id)) {
                    return (ResponseEntity.ok(persona));
                }
        }

        return ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity<List<?>> listPersonas(){
        return ResponseEntity.ok(personas);
    }

    @PostMapping
    public ResponseEntity<?> createPersona(@RequestBody Persona persona){

        this.personas.add(persona);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(persona.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<?> updatePersona(@RequestBody Persona personaModify){
        for(Persona persona : this.personas) {
            if(persona.getId().equals(personaModify.getId())){
                persona.setName(personaModify.getName());
                persona.setLastName(personaModify.getLastName());
                return ResponseEntity.ok(persona);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id){

        for (Persona persona: personas) {
            if (persona != null) {
                if (persona.getId().equals(id)) {
                    this.personas.remove(persona);
                    return ResponseEntity.noContent().build();
                }
            }
        }

        return ResponseEntity.notFound().build();
    }
}