package com.springsimplepasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplepasos.universidad.universidadbackend.modelo.dto.AlumnoDTO;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Alumno;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface AlumnoMapperConfig extends PersonaMapperConfig {
    @InheritConfiguration(name = "mapPersona")
    void mapAlumno(Alumno alumno, @MappingTarget  AlumnoDTO alumnoDTO);

}
