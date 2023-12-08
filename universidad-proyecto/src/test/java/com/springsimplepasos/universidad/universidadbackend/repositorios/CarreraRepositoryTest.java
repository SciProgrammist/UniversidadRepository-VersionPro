package com.springsimplepasos.universidad.universidadbackend.repositorios;

import com.springsimplepasos.universidad.universidadbackend.datos.DatosDummy;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Carrera;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarreraRepositoryTest {

    //El uso de repositorios es para poder llamar a los metodos y utilizarlos.
    @Autowired
    CarreraRepository carreraRepository;

    //Con esta anotacion las lineas que estan dentro del metodo se ejecutan antes del comienzo de este.
    @BeforeEach
    void setUp() {
        carreraRepository.save(DatosDummy.carrera01(false));
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03(false));
    }

    //Con esta anotacion se tiene la ejecucion del metodo luego de la ejecucion de este.
    @AfterEach
    void tearDown() {
        carreraRepository.deleteAll();
    }
    @Test
    @DisplayName("Buscar Carreras por nombre")
    void findCarerrasByNombreContains() {
        //given
         /*carreraRepository.save(DatosDummy.carrera01());
         carreraRepository.save(DatosDummy.carrera02());
         carreraRepository.save(DatosDummy.carrera03());*/

        //when
        Iterable<Carrera> expected = carreraRepository.findCarerrasByNombreContains("Sistemas");

        //then
        assertThat(((List<Carrera>)expected).size() == 2).isTrue();

    }

    @Test
    @DisplayName("Buscar Carreras por nombre No case sensitive")
    void findCarrerasByNombreContainsIgnoreCase() {
        //given
        /*carreraRepository.save(DatosDummy.carrera01());
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03());*/

        //when
        List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByNombreContainsIgnoreCase("sistemas");

        //then
        assertThat(expected.size() == 2).isTrue();
    }

    @Test
    @DisplayName("Buscar Carreras mayor a N años")
    void findCarrerasByCantidadAniosAfter() {
        //given
        /*carreraRepository.save(DatosDummy.carrera01());
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03());*/

        //when
        List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByCantidadAniosAfter(4);

        //then
        assertThat(expected.size() == 2).isTrue();
    }
}