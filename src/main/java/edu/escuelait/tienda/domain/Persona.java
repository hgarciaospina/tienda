package edu.escuelait.tienda.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@RequiredArgsConstructor
public class Persona {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @JsonIgnore
    private String lastName;

}
