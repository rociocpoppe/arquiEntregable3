package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Estudiante_Carrera;
import io.swagger.annotations.ApiModelProperty;

public class EstudianteDTO {


    @ApiModelProperty(notes="número de documento del estudiante", name="nroDni", required=true, value="378888999")
    private Long nroDni;
    @ApiModelProperty(notes="nombre del estudiante", name="nombre", required=true, value="Susana")
    private String nombre;
    @ApiModelProperty(notes="apellido del estudiante", name="apellido", required=true, value="Gimenez")
    private String apellido;
    @ApiModelProperty(notes="edad del estudiante", name="edad", required=true, value="34")
    private int edad;
    @ApiModelProperty(notes="género del estudiante", name="genero", required=true, value="f")
    private String genero;
    @ApiModelProperty(notes="ciudad de residencia del estudiante", name="ciudadResidencia", required=true, value="Tandil")
    private String ciudadResidencia;
    @ApiModelProperty(notes="número de libreta universitaria del estudiante", name="nrLibretaUniv", required=true, value="12034")
    private int nroLibretaUniv;
    @ApiModelProperty(notes="carreras del estudiante", name="carreras")
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
