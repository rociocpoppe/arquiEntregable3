package com.example.demo.dto;



import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class DTOReporte implements Serializable{

    @ApiModelProperty(notes="nombre de la carrera", name="c", required=true, value="Tudai")
    private String c;
    @ApiModelProperty(notes="fecha", name="fecha", required=true, value="21/04/2022")
    private Integer fecha;
    @ApiModelProperty(notes="inscriptos en la carrera", name="inscriptos", required=true, value="3")
    private double inscriptos;
    @ApiModelProperty(notes="graduados de la carrera", name="graduados", required=true, value="2")
    private double graduados;

    public DTOReporte() {
    }

    public DTOReporte(String o, Integer fechaInscripcion, double inscriptos, double graduados) {
        this.c = o;
        this.fecha = fechaInscripcion;
        this.inscriptos=inscriptos;
        this.graduados=graduados;
    }
    public String getC() {
        return c;
    }

    public Integer getFecha() {
        return fecha;
    }

    public double getInscriptos() {
        return inscriptos;
    }

    public double getGraduados() {
        return graduados;
    }

    
    public void setC(String c) {
        this.c = c;
    }

    public void setFecha(Integer fecha) {
        this.fecha = fecha;
    }

    public void setInscriptos(double inscriptos) {
        this.inscriptos = inscriptos;
    }

    public void setGraduados(double graduados) {
        this.graduados = graduados;
    }

    @Override
    public String toString() {
        return "DTOReporte [Carrera=" + c + ", fecha=" + fecha + ", inscriptos=" + inscriptos + ", graduados=" + graduados
                + "]";
    }
 
}
