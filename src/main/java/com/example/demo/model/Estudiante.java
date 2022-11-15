package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name="estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nroDni")
    @ApiModelProperty(notes="nro de dni del estudiante", name="nroDni", required=true, value="37888999")
    private Long nroDni;
    @Column
    @ApiModelProperty(notes="nombre del estudiante", name="nombre", required=true, value="Susana")
    private String nombre;
    @Column
    @ApiModelProperty(notes="apellido del estudiante", name="apellido", required=true, value="Gimenez")
    private String apellido;
    @Column
    @ApiModelProperty(notes="edad del estudiante", name="edad", required=true, value="34")
    private int edad;
    @Column
    @ApiModelProperty(notes="género del estudiante", name="genero", required=true, value="f")
    private String genero;
    @Column(name="ciudadResidencia")
    @ApiModelProperty(notes="ciudad de residencia del estudiante", name="ciudadResidencia", required=true, value="Tandil")
    private String ciudadResidencia;
    @Column(name="nroLibretaUniv")
    @ApiModelProperty(notes="número de libreta universitaria del estudiante", name="nrLibretaUniv", required=true, value="12034")
    private int nroLibretaUniv;

    @JsonIgnore
    @OneToMany (cascade=CascadeType.MERGE,mappedBy = "estudiante",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List <Estudiante_Carrera> carreras;
    
   
    public Estudiante(Long nroDni, String nombre, String apellido,  
    String ciudadResidencia,int edad, String genero,
            int nroLibretaUniv) {
        this.nroDni = nroDni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.nroLibretaUniv = nroLibretaUniv;
        // this.carreras=new ArrayList<Estudiante_Carrera>();
    }

    public Estudiante(Long nroDni, String nombre, String apellido, int nroLibretaUniv) {
        this.nroDni = nroDni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroLibretaUniv = nroLibretaUniv;
    }


    
    
    public Estudiante(Long nroDni, String nombre, String apellido, 
    String ciudadResidencia,int edad, String genero, 
            int nroLibretaUniv, List<Estudiante_Carrera> carreras) {
        this.nroDni = nroDni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.nroLibretaUniv = nroLibretaUniv;
        this.carreras = new ArrayList<Estudiante_Carrera>(carreras);
    }

    public Estudiante(Long nroDni) {
        this.nroDni = nroDni;
    }

    public Estudiante() {

    }

    public Long getNroDni() {
        return nroDni;
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

    public ArrayList<Estudiante_Carrera> getCarreras() {
        return new ArrayList<>(carreras);
    }


    @Override
    public String toString() {
        return "Estudiante [apellido=" + apellido + ", ciudadResidencia=" + ciudadResidencia
                + ", edad=" + edad + ", genero=" + genero + ", nombre=" + nombre + ", nroDni=" + nroDni
                + ", nroLibretaUniv=" + nroLibretaUniv + "]";
    }

   


    

}