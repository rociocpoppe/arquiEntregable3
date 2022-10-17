package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EnableJpaRepositories("com.example.demo.repository")
// @EntityScan("com.example.demo.repository.CarreraRepository")
// @EntityScan( "EstudianteRepository")
// @EntityScan("CarreraRepository")
//  @EntityScan("Estudiante_CarreraRepository")

public class Entregable3Application {

	public static void main(String[] args) {
		SpringApplication.run(Entregable3Application.class, args);
	}

}
