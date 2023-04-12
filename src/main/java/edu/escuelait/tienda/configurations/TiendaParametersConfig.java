package edu.escuelait.tienda.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "tienda")
@PropertySource(value = "classpath:parameters.properties")
public class TiendaParametersConfig {
    private String moneda;
    private String region;
}