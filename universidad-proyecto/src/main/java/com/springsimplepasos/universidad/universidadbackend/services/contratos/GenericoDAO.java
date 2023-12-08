package com.springsimplepasos.universidad.universidadbackend.services.contratos;

import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Carrera;

import java.util.Optional;

public interface GenericoDAO <E> {

    Optional<E> findById(Integer id); //Este optional nos permite encapsular el error del null pointer, y saber
    //si hay presencia de datos o no.
    E save(E entidad);
    Iterable<E> findAll();
    void deleteById(Integer id);
}
