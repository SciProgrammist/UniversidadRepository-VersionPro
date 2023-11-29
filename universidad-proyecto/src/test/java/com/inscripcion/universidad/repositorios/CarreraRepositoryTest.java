package com.inscripcion.universidad.repositorios;

import com.inscripcion.universidad.modelo.entidades.Carrera;
import com.inscripcion.universidad.repositorios.CarreraRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CarreraRepositoryTest {

    @Test
    @DisplayName("Buscar Carreras por nombre")
    void findCarrerasByNombreContains() {

    }

    @Test
    @DisplayName("Buscar carreras por nombre NO case sensitive")
    void findCarrerasByNombreContainsIgnoreCase() {
    }

    @Test
    @DisplayName("Buscar Carreras mayor a N años")
    void findCarrerasByCantidadAniosAfter() {

    }
}