package com.ejercicio3.ejercicioCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EjercicioCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioCrudApplication.class, args);
	}

	@Bean
	public List<Persona> registrarPersona(){
		return new ArrayList<>();
	}
}
