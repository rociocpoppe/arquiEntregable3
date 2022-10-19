package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Table(name="carrera")
public class Carrera{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idCarrera")
    private Long idCarrera;

    @Column
    private String nombre;

    private int duracion;


    @JsonManagedReference
    @OneToMany (cascade=CascadeType.ALL,mappedBy = "carrera",fetch= FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Estudiante_Carrera> estudiantes;

    public Carrera(Long id,String nombre, ArrayList<Estudiante_Carrera>estudiantes) {
        this.idCarrera=id;
        this.nombre = nombre;
        this.estudiantes=estudiantes;
    }

    public Carrera(Long idCarrera, String nombre, int duracion) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public Carrera(Long idCarrera, String nombre) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
    }

    public Carrera(){

    }
    
    public Long getIdCarrera() {
        return idCarrera;
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

    @Override
    public String toString() {
        return "Carrera [ idCarrera=" + idCarrera + ", nombre=" + nombre + "]";
    }


    public ArrayList<Estudiante_Carrera> getEstudiantes() {
         return new ArrayList<Estudiante_Carrera>(estudiantes);
    }

    
}
