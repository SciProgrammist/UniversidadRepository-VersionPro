package com.springsimplepasos.universidad.universidadbackend.services.contratos;

import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Carrera;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Optional;

public interface CarreraDAO extends GenericoDAO<Carrera> {

    Iterable<Carrera> findCarerrasByNombreContains(String nombre);
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);


}
