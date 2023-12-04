package com.inscripcion.universidad.datos;

import com.inscripcion.universidad.modelo.entidades.*;
import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.expression.spel.ast.NullLiteral;

import java.math.BigDecimal;

import static com.inscripcion.universidad.modelo.entidades.enumeradores.TipoProfesor.INTERNO;
import static com.inscripcion.universidad.modelo.entidades.enumeradores.TipoProfesor.EXTERNO;

//Esta clase es para proporcionar datos y no tener que escribirlos en todos los tests o duplicar los mismos.
public class DatosDummy {

    public static Carrera carrera01(boolean conId) {
        Carrera carrera = (conId) ? new Carrera(1, "Ingenieria en Sistemas", 50, "Computacion"):
                new Carrera(null, "Ingenieria en Sistemas", 50, "Computacion");
        return carrera;
    }
    public static Carrera carrera02() {
        return new Carrera(null, "Licenciatura en Sistemas", 45, "Computacion");
    }
    public static Carrera carrera03(boolean conId) {
        Carrera carrera = (conId) ? new Carrera(3, "Ingenieria Industrial", 60, "Computacion"):
                new Carrera(null, "Ingenieria Industrial", 60, "Computacion");
        return carrera;
    }


    public static Persona profesor01() {
        return new Profesor(null, "Martin", "Lugone", "33908461", "Soyapango", 60000.00);
    }

    public static Persona alumno01() {
        return new Alumno(null, "Jhon", "Benitez", "45233715", "nueva Soyapango","RP191495");
    }
    public static Persona alumno02() {
        return new Alumno(null, "Andres", "Benitez", "45233891", "Antiguo Cuscatlan","DR52727");
    }
    public static Persona alumno03() {
        return new Alumno(null, "Joaquin", "Leon", "45233012", "Mi casa","PS101010");
    }
}
