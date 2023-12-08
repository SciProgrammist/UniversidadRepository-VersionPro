package com.springsimplepasos.universidad.universidadbackend.repositorios;

import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean //Para que no nos genere un bean del repo, pero que si ineyecte los necesarios de nuestras clases hijas
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

    /* Se implementaran Queries JPQL para busquedas especificas que se tendran en la definicion de los
     * metodo de esta clase.
     * */
    @Query("select p from Persona p where p.nombre = ?1 and p.apellido = ?2")
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    @Query("select p from Persona p where p.dni = ?1")
    Optional<Persona> buscarPorDni(String dni);
    @Query("select p from Persona p where p.apellido like %?1%") //Para una busqueda mas amplia de lo que se esta buscando.
    Iterable<Persona> buscarPersonaPorApellido(String apellido);
}
