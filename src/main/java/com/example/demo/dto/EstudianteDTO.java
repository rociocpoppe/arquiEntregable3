package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Estudiante_Carrera;

public class EstudianteDTO {


    private Long nroDni;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudadResidencia;
    private int nroLibretaUniv;
    private List <Estudiante_Carrera> carreras;
    
    public EstudianteDTO(Long nroDni, String nombre, String apellido,
    String ciudadResidencia, int edad, String genero, 
            int nroLibretaUniv, List<Estudiante_Carrera> carreras) {
        this.nroDni = nroDni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.nroLibretaUniv = nroLibretaUniv;
        this.carreras = carreras;
    }


    
    public EstudianteDTO(Long nroDni, String nombre, String apellido, int edad) {
        this.nroDni = nroDni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public EstudianteDTO(Long nroDni, String nombre, String apellido, String ciudadResidencia,int edad, String genero, 
            int nroLibretaUniv) {
        this.nroDni = nroDni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.nroLibretaUniv = nroLibretaUniv;
    }



    public Long getNroDni() {
        return nroDni;
    }

    public void setNroDni(Long nroDni) {
        this.nroDni = nroDni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public int getNroLibretaUniv() {
        return nroLibretaUniv;
    }

    public void setNroLibretaUniv(int nroLibretaUniv) {
        this.nroLibretaUniv = nroLibretaUniv;
    }

    public List<Estudiante_Carrera> getCarreras() {
        return this.carreras;
    }

    public void addCarrera(Estudiante_Carrera carrera) {
        this.carreras.add(carrera);
    }


    
    
}
