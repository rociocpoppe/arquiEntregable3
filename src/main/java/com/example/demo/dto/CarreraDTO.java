package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Estudiante_Carrera;

public class CarreraDTO {

    private Long idCarrera;
    private String nombre;
    private int duracion;
    private int cantidadEstudiantes;
    private List<Estudiante_Carrera> estudiantes;

    public CarreraDTO(String nombre, int cantidadEstudiantes) {
        this.nombre = nombre;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }


    
    public CarreraDTO(Long idCarrera, String nombre, int duracion, int cantidadEstudiantes) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.duracion = duracion;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }


    public CarreraDTO(Long idCarrera, String nombre, int duracion) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.duracion = duracion;
    }


    public CarreraDTO(Long idCarrera, String nombre, int duracion, List<Estudiante_Carrera> estudiantes) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.duracion = duracion;
        this.estudiantes = estudiantes;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }
    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }
    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public List<Estudiante_Carrera> getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(Estudiante_Carrera es) {
        this.estudiantes.add(es);
    }

    


}
