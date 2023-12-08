package com.springsimplepasos.universidad.universidadbackend.controlador.dto;

import com.springsimplepasos.universidad.universidadbackend.modelo.dto.CarreraDTO;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplepasos.universidad.universidadbackend.modelo.mapper.CarreraMapper;
import com.springsimplepasos.universidad.universidadbackend.modelo.mapper.mapstruct.CarreraMapperMS;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class CarreraDtoController extends GenericDtoController<Carrera, CarreraDAO> {
    @Autowired
    private CarreraMapperMS mapper;
    public CarreraDtoController(CarreraDAO service) {
        super(service, "Carrera");
    }

    /* @Autowired
        private CarreraDAO carreraDAO;
        @Autowired
        private CarreraMapperMS mapper;*/
    @GetMapping
    public ResponseEntity<?> obtenerCarreras(){

        //Estructura de datos para generar un arreglo de clave valor
        Map<String, Object> mensaje = new HashMap();
        List<Carrera> carreras = super.obtenerTodos();

        //Algoritmo para validar y personalizar el Response.
        if(carreras.isEmpty()) {
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No se encontraron %ss cargadas", nombre_entidad));
            return ResponseEntity.badRequest().body(mensaje);
        }

        //
        List<CarreraDTO> carreraDTOS = carreras
                .stream()
                .map(mapper::mapCarrera)
                .collect(Collectors.toList());
        // De esta manera se transforma una lista de carreras, a carreraDto atraves de un mapper, y se devuelve a string.
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data",carreraDTOS);

        return ResponseEntity.ok(mensaje);
    }
}
