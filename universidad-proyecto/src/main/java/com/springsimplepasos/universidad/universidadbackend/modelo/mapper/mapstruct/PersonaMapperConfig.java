package com.springsimplepasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplepasos.universidad.universidadbackend.modelo.dto.PersonaDTO;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Persona;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

/*
* Estas interfaces sirven para que el mapper sepa que esto es una herencia.
*
* */
@MapperConfig
public interface PersonaMapperConfig {
    void mapPersona(Persona persona, @MappingTarget PersonaDTO personaDTO);

}
