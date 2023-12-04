package com.inscripcion.universidad.repositorios;

import com.inscripcion.universidad.datos.DatosDummy;
import com.inscripcion.universidad.modelo.entidades.Alumno;
import com.inscripcion.universidad.modelo.entidades.Persona;
import com.inscripcion.universidad.modelo.entidades.Profesor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.inscripcion.universidad.datos.DatosDummy.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonaRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;
    @Autowired
    @Qualifier("profesorRepository")
    PersonaRepository profesorRepository;


    @Test
    @DisplayName("Buscar por Nombre")
    void buscarPorNombre() {
        //Given
        Persona save = alumnoRepository.save(alumno01());

        //When
        Optional<Persona> expected = alumnoRepository.buscarPorNombre(alumno01().getNombre());

        //Then
        assertThat(expected.get()).isInstanceOf(Alumno.class);
        assertThat(expected.get()).isEqualTo(save);


    }

    @Test
    @DisplayName("Buscar por DUI")
    void buscarPorDui() {
        //Given
        Persona save = profesorRepository.save(profesor01());

        //When
        Optional<Persona> expected = profesorRepository.buscarPorDui(profesor01().getDui());

        //Then
        assertThat(expected.get()).isInstanceOf(Profesor.class);
        assertThat(expected.get()).isEqualTo(save);
        assertThat(expected.get().getDui()).isEqualTo(save.getDui());
    }

    @Test
    @DisplayName("Buscar persona por apellido")
    void buscarPersonaPorApellido() {
        // Given
        alumnoRepository.saveAll(Arrays.asList(
                alumno01(),
                alumno02(),
                alumno03()
        ));

        // When
        String apellido = "Benitez";
        List<Persona> expected = (List<Persona>) alumnoRepository.buscarPersonaPorApellido(apellido);

        //Then
        assertThat(expected.size() == 2).isTrue();


    }
}