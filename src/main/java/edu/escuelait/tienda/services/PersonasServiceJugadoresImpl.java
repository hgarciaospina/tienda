package edu.escuelait.tienda.services;

import edu.escuelait.tienda.domain.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("jugadores")
public class PersonasServiceJugadoresImpl implements PersonasService{

    ArrayList<Persona> personas = new ArrayList<>(
            List.of(new Persona(1L, "Roberto", "Rivelino"),
                    new Persona(2L, "Marinho", "Peres"),
                    new Persona(3L, "Waldir", "Peres")
            ));
    @Override
    public List<Persona > listAllPersonas(){
        return this.personas;
    }
}
