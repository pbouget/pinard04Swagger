package fr.pinard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Pinard04Swagger API", version = "3.0", description = "Démo Swagger 3.0"))
public class Pinard04SwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pinard04SwaggerApplication.class, args);
	}

}
