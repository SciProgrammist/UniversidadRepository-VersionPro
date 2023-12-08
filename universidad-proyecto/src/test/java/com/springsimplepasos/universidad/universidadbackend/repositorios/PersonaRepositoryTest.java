package com.springsimplepasos.universidad.universidadbackend.repositorios;

import com.springsimplepasos.universidad.universidadbackend.datos.DatosDummy;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Empleado;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Profesor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.springsimplepasos.universidad.universidadbackend.datos.DatosDummy.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonaRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;
    @Autowired
    @Qualifier("empleadoRepository")
    PersonaRepository empleadoRepository;
    @Autowired
    @Qualifier("profesorRepository")
    PersonaRepository profesoreRepository;

    @Test
    void buscarPorNombreYApellido() {
        //Given
        Persona save = empleadoRepository.save(empleado01());

        //When
        Optional<Persona> expected = empleadoRepository.buscarPorNombreYApellido(empleado01().getNombre(), empleado01().getApellido());

        //Then
        assertThat(expected.get()).isInstanceOf(Empleado.class); //expected.get() obtenemos el objeto
        assertThat(expected.get()).isEqualTo(save); //De esta manera estamos viendo que el empelado que se
        //inserto seria el mismo que recuperamos por nombre y apellido.
    }

    @Test
    void buscarPorDni() {
        //Given
        Persona save = profesoreRepository.save(profesor01());

        //When
        Optional<Persona> expected = profesoreRepository.buscarPorDni(profesor01().getDni());

        //Then
        assertThat(expected.get()).isInstanceOf(Profesor.class);
        assertThat(expected.get()).isEqualTo(save);
        assertThat(expected.get().getDni()).isEqualTo(save.getDni());
    }

    @Test
    void buscarPersonaPorApellido() {
        //Given
        Iterable<Persona> persona = alumnoRepository.saveAll(
                Arrays.asList(
                        alumno01(),
                        alumno02(),
                        alumno03()
                ));
        //When
        String apellido = "Benitez";
        List<Persona> expected = (List<Persona>) alumnoRepository.buscarPersonaPorApellido(apellido);

        //Then
        assertThat(expected.size() == 2).isTrue();

    }
}