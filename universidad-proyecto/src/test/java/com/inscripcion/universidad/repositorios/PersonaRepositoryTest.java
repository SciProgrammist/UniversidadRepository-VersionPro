package com.inscripcion.universidad.repositorios;



import com.inscripcion.universidad.modelo.entidades.Persona;
import com.inscripcion.universidad.modelo.entidades.Profesor;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class PersonaRepositoryTest {

    @Autowired
    @Qualifier("repositorioProfesores")
    ProfesorRepository profesorRepository;

    @Test
    void findProfesorByUsername() {
        //Given
        Profesor user02 = new Profesor(1, "Profe01", "Profe02","062266125", "casa", 2.0);
        profesorRepository.save(user02);
        //when
        String username = "Profesor01";
        Profesor expected = profesorRepository.findProfesorByName("Profe01");
        System.out.println(expected.toString());

        //then
        assertThat(expected.getNombre().equals(username)).isTrue();
    }
/*
    @Test
    void buscarPorDni() {
    }

    @Test
    void buscarPersonasPorApellido() {
    }*/
}