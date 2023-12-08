package com.springsimplepasos.universidad.universidadbackend.controlador.dto;

import com.springsimplepasos.universidad.universidadbackend.modelo.dto.AlumnoDTO;
import com.springsimplepasos.universidad.universidadbackend.modelo.dto.PersonaDTO;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Empleado;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Profesor;
import com.springsimplepasos.universidad.universidadbackend.modelo.mapper.mapstruct.AlumnoMapper;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.PersonaDAO;

public class PersonaDtoController extends GenericDtoController<Persona, PersonaDAO>{
    protected final AlumnoMapper alumnoMapper;

    public PersonaDtoController(PersonaDAO service, String nombre_entidad, AlumnoMapper alumnoMapper) {
        super(service, nombre_entidad);
        this.alumnoMapper = alumnoMapper;
    }

    public PersonaDTO altaPersona(Persona persona) {
        //Declarando las variables necesarias para trabajar con este metodo.
        Persona personaEntidad = super.altaEntidad(persona);
        PersonaDTO dto = null;

        //Condicion de validacion de datos.
        if(personaEntidad instanceof Alumno) {
            dto = alumnoMapper.mapAlumno((Alumno) personaEntidad);
        } else if (personaEntidad instanceof Profesor) {
            //aplicaremos mapper de profesor.
        } else if (personaEntidad instanceof Empleado) {
            //apliacmos el mapper de mepleado
        }

        //Finalizacion del metodo.
        return dto;

    }
}
