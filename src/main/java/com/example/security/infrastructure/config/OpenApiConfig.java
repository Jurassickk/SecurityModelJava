package com.example.security.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI securityModelOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Security Model API")
                        .version("1.0.0")
                        .description("API REST para gestión de seguridad con roles, permisos y usuarios.")
                        .contact(new Contact()
                                .name("Security Model Team")
                                .email("support@securitymodel.com")));
    }
}
