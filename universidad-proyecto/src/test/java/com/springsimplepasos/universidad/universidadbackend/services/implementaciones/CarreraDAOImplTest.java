package com.springsimplepasos.universidad.universidadbackend.services.implementaciones;

import com.springsimplepasos.universidad.universidadbackend.datos.DatosDummy;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplepasos.universidad.universidadbackend.repositorios.CarreraRepository;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.CarreraDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.springsimplepasos.universidad.universidadbackend.datos.DatosDummy.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CarreraDAOImplTest {
    CarreraDAO carreraDAO;
    CarreraRepository carreraRepository;

    @BeforeEach
    void setUp() {
        /** Metodo setUp que iniciara antes de cada test, usando la funcion mock
         *  se estara simulando repositorio atraves del mock.
         */
        carreraRepository = mock(CarreraRepository.class);
        carreraDAO = new CarreraDAOImpl(carreraRepository);
    }

    @Test
    void findCarerrasByNombreContains() {
        //Given
        String nombre = "Ingenieria";
        when(carreraRepository.findCarerrasByNombreContains(nombre))
                .thenReturn(Arrays.asList(carrera01(true), carrera03(true)));
        //When

        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarerrasByNombreContains(nombre);

        //Then
        assertThat(expected.get(0)).isEqualTo(carrera01(true));
        assertThat(expected.get(1)).isEqualTo(carrera03(true));

        verify(carreraRepository).findCarerrasByNombreContains(nombre);
    }

    @Test
    void findCarrerasByNombreContainsIgnoreCase() {
        //Given
        String nombre = "ingenieria";
        when(carreraRepository.findCarrerasByNombreContainsIgnoreCase(nombre))
                .thenReturn(Arrays.asList(carrera01(true), carrera03(true)));
        //When

        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombre);

        //Then
        assertThat(expected.get(0)).isEqualTo(carrera01(true));
        assertThat(expected.get(1)).isEqualTo(carrera03(true));

        verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(nombre);

    }

    @Test
    void findCarrerasByCantidadAniosAfter() {
        //Given
        int cantidad = 4;
        when(carreraRepository.findCarrerasByCantidadAniosAfter(cantidad))
                .thenReturn(Arrays.asList(carrera01(true), carrera03(true)));
        //When

        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(cantidad);

        //Then
        assertThat(expected.get(0)).isEqualTo(carrera01(true));
        assertThat(expected.get(1)).isEqualTo(carrera03(true));

        verify(carreraRepository).findCarrerasByCantidadAniosAfter(cantidad);
    }
}