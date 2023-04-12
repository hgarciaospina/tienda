package edu.escuelait.tienda.helpers;

import edu.escuelait.tienda.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ReportPDFImpl {

    public void generatePdfReport(List<Persona> personas){
        log.info("Generate PDF Report {}", personas);
    }
}