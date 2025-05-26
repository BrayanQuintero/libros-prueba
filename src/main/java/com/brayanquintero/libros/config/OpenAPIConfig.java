package com.brayanquintero.libros.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Spring boot REST API Documentatioon",
                description = "Spring boot books REST API Documentatioon",
                version = "v1.0",
                contact = @Contact(
                        name = "Brayan Quintero",
                        email = "correodeprueba@gmail.com",
                        url = "https://youtube.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://youtube.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring boot Books management documentation",
                url = "https://youtube.com"
        )
)
@Configuration
public class OpenAPIConfig {
}
