package com.springsimplepasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplepasos.universidad.universidadbackend.modelo.dto.CarreraDTO;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Carrera;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring") //Para que se sincronize con spring.
public interface CarreraMapperMS {

    @Mappings({
            @Mapping(source = "id", target = "codigo"),
            @Mapping(source = "cantidadMaterias", target = "cantidad_materias"),
            @Mapping(source = "cantidadAnios", target = "cantidad_anios"),
    })
    CarreraDTO mapCarrera(Carrera carrera);
}
