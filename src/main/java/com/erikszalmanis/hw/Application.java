package com.erikszalmanis.hw;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info= @Info(title = "Bank Transfer form", version = "0.5", description = "Half baked demo service. Mainly focused on the JAVA side. Refactoring is needed in the front-end part, once I get to it, I'll use typescript."))
public class Application {
    public static void main(final String[] args) {
        SpringApplication.run(Application.class);
    }
}
