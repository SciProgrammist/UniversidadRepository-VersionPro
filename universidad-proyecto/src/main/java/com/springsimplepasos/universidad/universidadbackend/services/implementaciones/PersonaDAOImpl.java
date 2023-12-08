package com.springsimplepasos.universidad.universidadbackend.services.implementaciones;

import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplepasos.universidad.universidadbackend.repositorios.PersonaRepository;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.PersonaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaDAOImpl extends GenericDAOImpl<Persona, PersonaRepository> implements PersonaDAO{

    public PersonaDAOImpl(PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
        return repository.buscarPorNombreYApellido(nombre, apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorDni(String dni) {
        return repository.buscarPorDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarPersonaPorApellido(String apellido) {
        return repository.buscarPersonaPorApellido(apellido);
    }
}
