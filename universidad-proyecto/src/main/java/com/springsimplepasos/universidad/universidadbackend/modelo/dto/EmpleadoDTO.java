package com.springsimplepasos.universidad.universidadbackend.modelo.dto;

import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Direccion;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class EmpleadoDTO extends PersonaDTO {

    private BigDecimal sueldo;
    private TipoEmpleado tipoEmpleado;

    public EmpleadoDTO(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo, TipoEmpleado tipoEmpleado) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
    }
}
