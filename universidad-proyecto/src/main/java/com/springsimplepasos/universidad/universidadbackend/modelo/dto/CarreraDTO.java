package com.springsimplepasos.universidad.universidadbackend.modelo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

/*
* El proposito de esta clase es para usar el patron Data Transformation Object.
* esto se usa para cuando se quiere mandar un objeto con datos especificos al frontEnd, aqui se definen.
* */
/*@Setter //Genera mediante lombok los Setters.
@Getter
@NoArgsConstructor
@AllArgsConstructor //Genera mediante lombok un constructor con todos los argumentos.
@ToString
@EqualsAndHashCode*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO {
    private Integer codigo;
    @NotNull
    @NotEmpty(message = "Debe de ingresar un valor")
    @Size(min = 0, max = 80)
    private String nombre;
    @Positive(message = "El valor no puede ser negativo")
    private Integer cantidad_materias;
    @Positive(message = "El valor no puede ser negativo")
    private Integer cantidad_anios;


}
