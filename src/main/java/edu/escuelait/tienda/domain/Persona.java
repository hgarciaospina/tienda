package edu.escuelait.tienda.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Schema(description = "Atributos de Persona")
@Data
public class Persona {
    @NonNull
    @Schema(description = "Identificador único de Persona.", example = "1")
    private Long id;
    @NonNull
    @Schema(description = "Nombre(s) de la Persona.", example = "Henry")
    private String name;
    @NonNull
    @Schema(description = "Apellido(s) de la Persona.", example = "García Ospina")
    private String lastName;
}
