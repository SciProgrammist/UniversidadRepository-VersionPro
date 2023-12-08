package com.springsimplepasos.universidad.universidadbackend.controlador.dto;

import com.springsimplepasos.universidad.universidadbackend.modelo.dto.AlumnoDTO;
import com.springsimplepasos.universidad.universidadbackend.modelo.dto.PersonaDTO;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplepasos.universidad.universidadbackend.modelo.mapper.mapstruct.AlumnoMapper;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.PersonaDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class AlumnoDtoController extends PersonaDtoController {
    /*@Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;
    @Autowired
    private AlumnoMapper mapper;*/

    public AlumnoDtoController(PersonaDAO service, AlumnoMapper alumnoMapper) {
        super(service, "Alumno", alumnoMapper);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer id){
        Map<String, Object> mensaje = new HashMap<>();
        // Optional<Persona> oPersona = personaDAO.findById(id);

        // PersonaDTO dto = mapper.mapAlumno((Alumno) oPersona.get());

        mensaje.put("sucess", Boolean.TRUE);
        //mensaje.put("data", dto);

        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> altaAlumno(@Valid @RequestBody PersonaDTO personaDTO, BindingResult result) {
        Map<String, Object> mensaje = new HashMap<>();

        if(result.hasErrors()) {
            mensaje.put("success", Boolean.FALSE);
           /* Map<String, Object> validaciones = new HashMap<>();
            result.getFieldErrors()
                    .forEach(error -> validaciones.put(error.getField(), error.getDefaultMessage()));*/
            mensaje.put("validaciones", super.obtenerValidaciones(result));
            return ResponseEntity.badRequest().body(mensaje);
        }

        //Persona save = personaDAO.save(mapper.mapAlumno((AlumnoDTO) personaDTO));
        PersonaDTO save = super.altaPersona(alumnoMapper.mapAlumno((AlumnoDTO) personaDTO));
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data", save);

        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);

    }

}
