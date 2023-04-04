package edu.escuelait.tienda.services;

import edu.escuelait.tienda.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Lazy
@Service("jugadores")
public class PersonasServiceJugadoresImpl implements PersonasService{

    ArrayList<Persona> jugadores = new ArrayList<>(
            List.of(new Persona(1L, "Roberto", "Rivelino"),
                    new Persona(2L, "Marinho", "Peres"),
                    new Persona(3L, "Waldir", "Peres")
            ));

    public PersonasServiceJugadoresImpl() {
        log.info( "Ejecutando constructor de PersonasServiceJugadoresImpl");
    }

    @Override
    public List<Persona > listAllPersonas(){
        return this.jugadores;
    }
}
