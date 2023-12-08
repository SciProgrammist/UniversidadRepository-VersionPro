package com.springsimplepasos.universidad.universidadbackend.services.implementaciones;

import com.springsimplepasos.universidad.universidadbackend.repositorios.AlumnoRepository;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.AlumnosDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class AlumnoDAOImplTest {

    @MockBean //Decoracion de SpringFramework y no de moquito :3
    AlumnoRepository alumnoRepository;
    @Autowired //Autowired >:v
    AlumnosDAO alumnosDAO;
    @Test
    void buscarAlumnosPorNombreCarrera() {
        //When
        alumnosDAO.buscarAlumnosPorNombreCarrera(anyString());
        //Then
        verify(alumnoRepository).buscarAlumnosPorNombreCarrera(anyString());
    }

}