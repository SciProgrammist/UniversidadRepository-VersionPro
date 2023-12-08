package com.springsimplepasos.universidad.universidadbackend.services.contratos;

import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona> {

    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    Optional<Persona> buscarPorDni(String dni);
    Iterable<Persona> buscarPersonaPorApellido(String apellido);

}
