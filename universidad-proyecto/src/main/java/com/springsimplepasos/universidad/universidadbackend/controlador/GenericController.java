package com.springsimplepasos.universidad.universidadbackend.controlador;

import com.springsimplepasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.GenericoDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Deprecated
public class GenericController <E, S extends GenericoDAO<E>>{

    protected final S service; //Variable protejida que sera el servicio del GenericDAO
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodos() { //Se retornara un response entity, ? 'significa que se puede enviar cualquier cosa'
        Map<String, Object> mensaje =  new HashMap<>();

        List<E> listado = (List<E>) service.findAll();

        if(listado.isEmpty()) {
            //throw new BadRequestException(String.format("No se han encontrado %ss", nombreEntidad));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No existen %ss", nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje); //Manera en que se retorna un mensaje personalizado.
        }
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", listado);

        return  ResponseEntity.ok(mensaje);
    }

    //obtenerPorID (Id)

    //borrarEntidadPorId (Id)

    //altaEntidad (Entidad)
}