package com.springsimplepasos.universidad.universidadbackend.controlador;

import com.springsimplepasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.CarreraDAO;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Deprecated //Esta anotacion es para indicarle algun otro desarrollardor que esta clase no tiene continuida y que hasta aqui llego su desarrollo.
@RestController //Anotacion para nuestra REST api
@RequestMapping("/carreras") //Definiendo un end-point para la aplicacion.
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "false")
public class CarreraController extends GenericController<Carrera, CarreraDAO> {

    //private final CarreraDAO carreraDAO; //El servicio

    //@Autowired para que instancie el DAO
    //public CarreraController(CarreraDAO carreraDAO) {this.carreraDAO = carreraDAO;} <-Antes del refactor
    @Autowired
    public CarreraController(CarreraDAO service) {
        super(service);
        nombreEntidad = "Carrera";
    }

    /*@GetMapping
    public List<Carrera> obtenerTodos(){
        List<Carrera> carreras = (List<Carrera>) service.findAll();
        if(carreras.isEmpty()) {
            throw new BadRequestException("No existen carreras");
        }
        return carreras;
    }*/

   /*@GetMapping("/{codigo}")
    public Carrera obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id) {
        Optional<Carrera> oCarrera = service.findById(id);
        if(!oCarrera.isPresent()) {
            throw new BadRequestException(String.format("La carrera con id %d no existe", id));
        }
        return oCarrera.get();
    } */

    @PostMapping //Carrera que sera persistida en la base de datos.
    public ResponseEntity<?> altaCarrera(@Valid @RequestBody Carrera carrera, BindingResult result) { //Esta firma en el argumento se tiene una anotacion
        // que hace que reconosca que el JSON que viene en el body representa un objeto carrera.
        //Validaciones
        /*if(carrera.getCantidadAnios() < 0 ) {
            throw new BadRequestException("El campo cantida de años no puede ser negativo");
        }
        if(carrera.getCantidadMaterias() < 0 ) {
            throw new BadRequestException("El campo cantida de materias no puede ser negativo");
        }*/
        Map<String, Object> validaciones = new HashMap<>();

        if(result.hasErrors()) {
            result.getFieldErrors()
                    .forEach(error -> validaciones.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(validaciones);
        }

        return ResponseEntity.ok(service.save(carrera));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCarrera(@PathVariable  Integer id, @RequestBody Carrera carrera){
        //Esta linea es para poder enviar un mensaje como Response
        Map<String, Object> mensaje = new HashMap<>();
        Carrera carreraUpdate = null;
        Optional<Carrera> oCarrera = service.findById(id);

        if(!oCarrera.isPresent()){
            //throw new BadRequestException(String.format("La carrera con id %d no existe", id));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("%s con ID %d no existe", nombreEntidad, id));
            return ResponseEntity.badRequest().body(mensaje);
        }

        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());

        mensaje.put("datos", service.save(carreraUpdate));
        mensaje.put("success", Boolean.TRUE);

        return ResponseEntity.ok(mensaje);
    }

    /*@DeleteMapping("/{id}")
    public void eliminarCarrera(@PathVariable Integer id) {
        service.deleteById(id);
    }*/

    //NOTA: Se comentaron los metodos porque se encuentran sus definiciones en GenericController.
}
