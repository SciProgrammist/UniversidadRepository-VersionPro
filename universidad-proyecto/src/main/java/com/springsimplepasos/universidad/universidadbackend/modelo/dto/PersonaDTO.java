package com.springsimplepasos.universidad.universidadbackend.modelo.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Direccion;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AlumnoDTO.class, name = "alumno"), //Cuando venda un tipo alumno va a hacer la instancia de esa clase.
        @JsonSubTypes.Type(value = ProfesorDTO.class, name = "profesor")
})
public abstract class PersonaDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    @Pattern(regexp= "[0-9]+")
    @Size(min = 1, max= 10)
    private String dni;
    private Direccion direccion;
}
