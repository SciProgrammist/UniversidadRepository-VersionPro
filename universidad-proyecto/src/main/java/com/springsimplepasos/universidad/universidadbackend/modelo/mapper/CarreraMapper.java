package com.springsimplepasos.universidad.universidadbackend.modelo.mapper;

import com.springsimplepasos.universidad.universidadbackend.modelo.dto.CarreraDTO;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Carrera;

/*
* El mapper nos transforma de un objeto carrera a un objeto DTO, y se usa en nuestras clases
* del paquete dto.
* */
@Deprecated
public class CarreraMapper {
    public static CarreraDTO mapCarrera(Carrera carrera) {
        CarreraDTO dto = new CarreraDTO();
        dto.setCodigo(carrera.getId());
        dto.setNombre(carrera.getNombre());
        dto.setCantidad_anios(carrera.getCantidadAnios());
        dto.setCantidad_materias(carrera.getCantidadMaterias());
        return dto;
    }


}

