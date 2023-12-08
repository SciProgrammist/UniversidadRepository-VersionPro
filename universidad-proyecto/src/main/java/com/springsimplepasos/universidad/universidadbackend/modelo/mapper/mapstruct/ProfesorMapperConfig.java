package com.springsimplepasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplepasos.universidad.universidadbackend.modelo.dto.ProfesorDTO;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Profesor;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface ProfesorMapperConfig extends PersonaMapperConfig{
    @InheritConfiguration(name = "mapPersona")
    void mapProfesor(Profesor profesor, @MappingTarget ProfesorDTO profesorDTO);
}
