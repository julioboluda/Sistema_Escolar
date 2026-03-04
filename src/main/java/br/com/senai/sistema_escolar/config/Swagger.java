package br.com.senai.sistema_escolar.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Sistema Escolar API - Julio Cesar Boluda",
        version = "1.0",
        description = "API para o sistema Escolar"
    )
)
public class Swagger {

}