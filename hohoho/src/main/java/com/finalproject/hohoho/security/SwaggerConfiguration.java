package com.finalproject.hohoho.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
    	OpenAPI openApi = new OpenAPI().addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
            .components(new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
            .info(new Info().title("Hamaca")
                .description("description of API.")
                .version("1.0")
                .license(new License().name("License of API")
                    .url("API license URL")));
    	Server server = new Server();
    	server.setUrl("https://sru-abi-rlm-project-backend-production.up.railway.app/");
    	openApi.addServersItem(server);
    	System.out.println("SERVIDOR CUSTOM" + server.toString());
        return openApi;
    }
    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
            .bearerFormat("JWT")
            .scheme("bearer")
            .description("Authorize Client");
    }
}