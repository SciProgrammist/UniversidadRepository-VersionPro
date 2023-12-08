package com.springsimplepasos.universidad.universidadbackend.repositorios;

import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    //La definicion de estos metodos son otra opcion a las queries que se han comentado arriba de ellos.
    //para saber como hacer mas de estos es de dirigirse a la documentacion de SpringBoot.

    // @Query("select c from Carrera c where c.nombre like %?1%")
    Iterable<Carrera> findCarerrasByNombreContains(String nombre);

    // @Query("select c from Carrera c where upper(c.nombre) like upper(%?1%)")
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    // @Query("select c from Carrera c where c.cantidadAnios < ?1")
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

}
