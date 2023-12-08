package com.springsimplepasos.universidad.universidadbackend.services.implementaciones;

import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplepasos.universidad.universidadbackend.repositorios.CarreraRepository;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CarreraDAOImpl extends GenericDAOImpl<Carrera,CarreraRepository> implements CarreraDAO {


    @Autowired //Para inyeccion de dependencias.
    public CarreraDAOImpl(CarreraRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Carrera> findCarerrasByNombreContains(String nombre) {
        return repository.findCarerrasByNombreContains(nombre);
    }

    @Override
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {
        return repository.findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Override
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios) {
        return repository.findCarrerasByCantidadAniosAfter(cantidadAnios);
    }
}
