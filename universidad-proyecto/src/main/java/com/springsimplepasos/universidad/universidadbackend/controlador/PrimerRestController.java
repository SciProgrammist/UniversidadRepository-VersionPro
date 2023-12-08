package com.springsimplepasos.universidad.universidadbackend.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/restapi")
public class PrimerRestController {
    //Los logger son para no siempre depender de la consola para debugger la aplicacion.
    Logger logger = LoggerFactory.getLogger(PrimerRestController.class);

    @GetMapping("/hola-mundo") //Estos son nuestros end-point, osea a lo que se le hara un request mediante el protocolo http
    public ResponseEntity<Map<String, String>> holaMundo(){
        Map<String, String> mensaje = new HashMap<>();
        mensaje.put("saludo","Hola Mundo! =D");
        //Atraves de una property se puede especificar que se logge desde aqui
        logger.trace("trace log");
        logger.debug("debug log"); //Desde aqui para --Anvientes Desarollo.
        logger.info("info log"); //Apartir de aqui Spring loggea Spring --Anvientes Productivos.
        logger.warn("warning log");
        logger.error("error log");
        return new ResponseEntity<>(mensaje, HttpStatus.ACCEPTED);
    }

    //Ahora al encapsular el dato se puede personalizar mucho mas el Response, con la clase ResponseEntity.
    //Como https status, los headers, y muchas mas cosas, las cookies y lo demas.
}
