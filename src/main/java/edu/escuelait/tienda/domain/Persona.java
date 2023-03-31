package edu.escuelait.tienda.domain;

import lombok.*;

@Data
@RequiredArgsConstructor
public class Persona {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    private String lastName;

}
