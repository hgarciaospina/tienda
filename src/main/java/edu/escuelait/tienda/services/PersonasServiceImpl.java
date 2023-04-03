package edu.escuelait.tienda.services;

import edu.escuelait.tienda.domain.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonasServiceImpl implements PersonasService{

    ArrayList<Persona> personas = new ArrayList<>(
            List.of(new Persona(1L, "James", "Gosling"),
                    new Persona(2L, "Linus", "Torvalds"),
                    new Persona(3L, "Dennis", "Ritchie")
            ));
    @Override
    public List<Persona > listAllPersonas(){
        return this.personas;
    }
}
