package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Estudiante_Carrera;

public class CarreraDTO {

    private Long idCarrera;
    private String nombre;
    private int duracion;
    private List<Estudiante_Carrera> estudiantes;

    

    public CarreraDTO(Long idCarrera, String nombre, int duracion, List<Estudiante_Carrera> estudiantes) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.duracion = duracion;
        this.estudiantes = estudiantes;
    }
    public Long getIdCarrera() {
        return idCarrera;
    }
    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public void setEstudiantes(List<Estudiante_Carrera> estudiantes) {
        this.estudiantes = estudiantes;
    }

    


}
