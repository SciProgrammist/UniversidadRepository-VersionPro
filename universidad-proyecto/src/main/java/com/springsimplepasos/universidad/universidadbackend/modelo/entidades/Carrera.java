package com.springsimplepasos.universidad.universidadbackend.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "carreras")
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /*@NotNull
    @NotEmpty(message = "Debe de ingresar un valor")
    @Size(min = 0, max = 80)*/
    //@javax.validation.constraints.(@Max, @Pattern(regx = ""), @Min, etc...)
    @Column(name = "nombre_carrera", nullable = false, unique = true, length = 80)
    private String nombre;
    //@Positive(message = "El valor no puede ser negativo")
    @Column(name = "cantidad_materias")
    private Integer cantidadMaterias;
    //@Positive(message = "El valor no puede ser negativo")
    @Column(name = "cantidad_anios")
    private Integer cantidadAnios;
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
    @OneToMany(
            mappedBy = "carrera",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"carrera"}) //De la clase alumno alumno no tendra encuenta el lazy de la relacion bi-dereccional
    private Set<Alumno> alumnos;
    @ManyToMany(
            mappedBy = "carreras",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties("carreras")
    private Set<Profesor> profesors;

    public Carrera() {
    }

    public Carrera(Integer id, String nombre, Integer cantidadMaterias, Integer cantidadAnios) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadMaterias = cantidadMaterias;
        this.cantidadAnios = cantidadAnios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(Integer cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public Integer getCantidadAnios() {
        return cantidadAnios;
    }

    public void setCantidadAnios(Integer cantidadAnios) {
        this.cantidadAnios = cantidadAnios;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Profesor> getProfesors() {
        return profesors;
    }

    public void setProfesors(Set<Profesor> profesors) {
        this.profesors = profesors;
    }

    //Metodo propio de clase para manejar el apartado de fechas.

    @PrePersist //Antes de hacer la persistencia de objeto de ejecutara este metodo
    private void antesDePersistir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate //Antes de hacer la actualizacion del objeto se ejecutara este metodo
    private  void anteDeUpdate(){
        this.fechaModificacion = LocalDateTime.now();
    }

    //Nota: JPA se encargara automaticamente de hacerlo por nosotros.

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidadMaterias=" + cantidadMaterias +
                ", cantidadAnios=" + cantidadAnios +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return id.equals(carrera.id) && nombre.equals(carrera.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
