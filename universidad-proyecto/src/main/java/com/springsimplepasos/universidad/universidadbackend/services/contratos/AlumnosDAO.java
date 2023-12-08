package com.springsimplepasos.universidad.universidadbackend.services.contratos;

import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Persona;

public interface AlumnosDAO extends PersonaDAO {

    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
}
