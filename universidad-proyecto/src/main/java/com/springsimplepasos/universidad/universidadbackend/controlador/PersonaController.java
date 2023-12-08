package com.springsimplepasos.universidad.universidadbackend.controlador;

import com.springsimplepasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.PersonaDAO;
import jakarta.persistence.ForeignKey;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Deprecated
public class PersonaController extends GenericController<Persona , PersonaDAO> {

    public PersonaController(PersonaDAO service) {
        super(service);
    }

    //@GetMapping("/nombre-apellido/{nombre}/{apellido}") esta anotacion funciona porque los nombre de los atributos son los mismos de los argumentos
    @GetMapping("/nombre-apellido") //Esta es otra forma de hacerlo, pero se debe de usar otras anotaciones en los argumentos.
    public ResponseEntity<?> buscarPersonaPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Map<String, Object> mensaje = new HashMap<>();
        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
        if(!oPersona.isPresent()) {
            //throw new BadRequestException(String.format("No se encontro Persona con nombre %s y apellido %s", nombre, apellido));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No se encontro Persona con nombre %s y apellido %s", nombre, apellido));
            return ResponseEntity.badRequest().body(mensaje);

        }

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", oPersona.get());

        return ResponseEntity.ok(mensaje);

    }
}
