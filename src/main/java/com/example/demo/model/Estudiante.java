package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name="estudiante")
public class Estudiante{

    @Id
    @Column(name="nroDni")
    private Long nroDni;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;
    @Column
    private String genero;
    @Column(name="ciudadResidencia")
    private String ciudadResidencia;
    @Column(name="nroLibretaUniv")
    private int nroLibretaUniv;

    @JsonManagedReference
    @OneToMany (cascade=CascadeType.ALL,mappedBy = "estudiante",fetch = FetchType.LAZY)
    private List <Estudiante_Carrera> carreras;
    
   
    public Estudiante(Long nroDni, String nombre, String apellido,  String ciudadResidencia,int edad, String genero,
            int nroLibretaUniv) {
        this.nroDni = nroDni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.nroLibretaUniv = nroLibretaUniv;
        this.carreras=new ArrayList<Estudiante_Carrera>();
    }

    public Estudiante(Long nroDni, String nombre, String apellido, int nroLibretaUniv) {
        this.nroDni = nroDni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroLibretaUniv = nroLibretaUniv;
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

    // public void addCarrera(Carrera carrera) {
    //     Estudiante_Carrera cs = new Estudiante_Carrera(this, carrera);
    //     carreras.add(cs);
    //     carrera.getEstudiantes().add(cs);
    // }

    @Override
    public String toString() {
        return "Estudiante [apellido=" + apellido + ", ciudadResidencia=" + ciudadResidencia
                + ", edad=" + edad + ", genero=" + genero + ", nombre=" + nombre + ", nroDni=" + nroDni
                + ", nroLibretaUniv=" + nroLibretaUniv + "]";
    }

   


    

}