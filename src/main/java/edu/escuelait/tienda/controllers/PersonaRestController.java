package edu.escuelait.tienda.controllers;

import edu.escuelait.tienda.domain.Persona;
import edu.escuelait.tienda.services.PersonasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personas")
@Tag(name = "API Personas - ",
    description = "CRUD Personas")
public class PersonaRestController {

    PersonasService personasService;

    public PersonaRestController(@Qualifier("jugadores") PersonasService personasService) {
        this.personasService = personasService;
    }

    ArrayList<Persona> personas = new ArrayList<>(
        List.of(new Persona(1L, "Rafael", "Celeste"),
                new Persona(2L, "Miguel", "Astuias"),
                new Persona(3L, "Alvaro", "Mejía")
        ));

    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    @ApiResponse(responseCode = "400", description = "Error de petición")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    @Operation(summary = "Recupera una persona por Id",
               description = "Recupera una persona dado un id de tipo númerico"
              )
    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonaById(
            @Parameter(description = "Id de persona. Valor entero", required = true, example = "1")
            @PathVariable Long id){

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
    public ResponseEntity<List<?>> listPersonas()
    {
        return ResponseEntity.ok(personasService.listAllPersonas());

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