package com.inscripcion.universidad.repositorios;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class AlumnoRepositoryTest {

  @Autowired
  @Qualifier("repositorioAlumnos")
  PersonaRepository alumnoRepository;
  @Autowired
  CarreraRepository carreraRepository;
  @Test
  void buscarAlumnosPorNombreCarrera() {
    //TODO
  }
  }
