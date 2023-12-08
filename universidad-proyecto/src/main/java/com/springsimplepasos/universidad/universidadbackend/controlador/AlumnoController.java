package com.springsimplepasos.universidad.universidadbackend.controlador;

import com.springsimplepasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplepasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.CarreraDAO;
import com.springsimplepasos.universidad.universidadbackend.services.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//Para poner la clase como aplicacion Rest
@Deprecated // Tambien significa que no se usara más.
@RestController
@RequestMapping("/alumnos")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "false")
public class AlumnoController extends PersonaController {
    //final para poder generarlo en el constructor
    private final CarreraDAO carreraDAO;
    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDao, CarreraDAO carreraDAO) {
        super(alumnoDao);
        nombreEntidad = "Alumno";
        this.carreraDAO = carreraDAO;
    }

    //Crear "C" -C
    /*@PostMapping //Anotacion para hacer las altas y se compara como un metodo Post
    public Persona altaAlumno(@RequestBody Persona alumno) {
        return alumnoDao.save(alumno);
    } */

    //Leer  "R" -CR
   /* @GetMapping("/{id}")
    public Persona obtenerAlumnoPorId(@PathVariable(required = false) Integer id) {
        Optional<Persona> oAlumno = alumnoDao.findById(id);
        if(!oAlumno.isPresent()) {
            throw new BadRequestException(String.format("Alumno con id %d no existe", id));
        }
        return oAlumno.get();
    }

    @GetMapping
    public List<Persona> obtenerTodos() {
        List<Persona> alumnos = (List<Persona>) alumnoDao.findAll();
        if(alumnos.isEmpty()) {
            throw new BadRequestException("No existe alumnos");
        }
        return alumnos;
    } */

    //Update "U" -CRU
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno){
        Map<String, Object> mensaje = new HashMap<>();
        Persona alumnoUpdate = null;
        Optional<Persona> oAlumno = service.findById(id);
        if(!oAlumno.isPresent()) {
            //throw new BadRequestException(String.format("Alumno con id %d no existe", id));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Alumno con id %d no existe", id));
            return  ResponseEntity.badRequest().body(mensaje);
        }
        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());

        mensaje.put("datos", service.save(alumnoUpdate));
        mensaje.put("success", Boolean.TRUE);
        return ResponseEntity.ok(mensaje);
    }

    //Delete "D" -CRUD
    /*  @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id) {
        alumnoDao.deleteById(id);
    }
    */

    //Metodos extra para poder asignar una carrera a un alumno.
    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer idAlumno,@PathVariable Integer idCarrera) {
        Map<String, Object> mensaje = new HashMap<>();
        // 1) es averiguar si la carrera existe y si el alumno tambien.
        Optional<Persona> oAlumno = service.findById(idAlumno);
        if(!oAlumno.isPresent()) {
            //throw new BadRequestException(String.format("Alumno con id %d no existe", idAlumno));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Alumno con id %d no existe", idAlumno));
            return  ResponseEntity.badRequest().body(mensaje);
        }
        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if(!oCarrera.isPresent()) {
            //throw  new BadRequestException(String.format("Carrera con id %d no existe", idCarrera));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Carrera con id %d no existe", idCarrera));
            return  ResponseEntity.badRequest().body(mensaje);
        }
        // 2) Ahora que si sabemos que existes se comienza a hacer sus asociaciones respectivas.
        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.get();
        // 3) Creamos la sociacion de la carrera con el alumno
        ((Alumno)alumno).setCarrera(carrera);
        // 4) Usando la Data Access Object se usa el metodo del contrato para guardar la entidad Alumno.
        mensaje.put("datos", service.save(alumno));
        mensaje.put("success", Boolean.TRUE);

        return ResponseEntity.ok(mensaje);
    }

}
