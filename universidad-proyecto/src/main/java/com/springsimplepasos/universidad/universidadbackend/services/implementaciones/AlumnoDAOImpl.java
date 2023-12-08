package com.springsimplepasos.universidad.universidadbackend.services.implementaciones;

import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplepasos.universidad.universidadbackend.repositorios.AlumnoRepository;
import com.springsimplepasos.universidad.universidadbackend.repositorios.PersonaRepository;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.AlumnosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//Operaciones CRUD del DAO de personas
@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnosDAO {
    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre) {
        return ((AlumnoRepository)repository).buscarAlumnosPorNombreCarrera(nombre);
    }
}
