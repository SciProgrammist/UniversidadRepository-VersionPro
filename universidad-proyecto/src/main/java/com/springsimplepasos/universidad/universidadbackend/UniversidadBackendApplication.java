package com.springsimplepasos.universidad.universidadbackend;

import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Direccion;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.AlumnosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UniversidadBackendApplication {

	public static void main(String[] args) {
		/**
		 * Nota: ComandosPruebas.rar contiene unas clases las cuales contienen unos comandos de practica que se usaron
		 * para probar los repositorios, lo cual no es una buena practica ya que cuando la aplicacion este desplegada
		 * se podrian ejecutar y es por eso que es recomendable hacerlo mediante los test.
		 * */
		String[] beanDefinitionNames = SpringApplication.run(UniversidadBackendApplication.class, args).getBeanDefinitionNames();
		/**
		 * Patron DTO: Data Transfer Object, es un objeto que se utilizara para transferir informacion
		 *
		 * */
	}
}
