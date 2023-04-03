package edu.escuelait.tienda.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Tienda Escuela IT API",
                description = "Tienda Escuela IT Microservicio",
                contact = @Contact(
                        name = "Henry García Ospina",
                        url = "https://ingenieriahgo.com",
                        email = "henrygarciaospina@gmail.com"
                ),
                license = @License(
                      name = "MIT Licence",
                      url =  "https://github.com/hgarciaospina")),
        servers = @Server(url = "http://localhost:8080")
)

public class SwaggerConfiguration {
}
