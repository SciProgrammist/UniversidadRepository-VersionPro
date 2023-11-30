package com.inscripcion.universidad.repositorios;


import com.inscripcion.universidad.modelo.entidades.Carrera;
import org.springframework.data.repository.CrudRepository;

public interface CarreraRepository extends CrudRepository<Carrera, Integer> {

    //Ctrl +shif+ t =test


    Iterable<Carrera> findCarrerasByNombreContains(String sistemas);
}
