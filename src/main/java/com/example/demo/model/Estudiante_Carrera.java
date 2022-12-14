package com.example.demo.model;


import java.sql.Timestamp;


import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table (name="estudiante_carrera")
public class Estudiante_Carrera{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;

    @JsonBackReference
    @ManyToOne( cascade = CascadeType.MERGE, fetch= FetchType.LAZY)
    @JoinColumn (name="estudianteId")
    private Estudiante estudiante;

    @JsonBackReference
    @ManyToOne (fetch= FetchType.LAZY)
    @JoinColumn (name="carreraId")
    private Carrera carrera;

	private Timestamp fechaInscripcion;
	private Timestamp fechaGraduacion;
    private int antiguedad;

    public Estudiante_Carrera() {
		super();
	}

    
    public Estudiante_Carrera(Estudiante estudiante2, Carrera carrera2) {
        this.estudiante = estudiante2;
        this.carrera = carrera2;
    }


    public Estudiante_Carrera(Estudiante e, Carrera c, Timestamp inscripcion, Timestamp graduacion) {
        this.estudiante = e;
        this.carrera = c;
        this.fechaInscripcion=inscripcion;
        this.fechaGraduacion=graduacion;
    }


    public Long getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Timestamp getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Timestamp fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Timestamp getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(Timestamp fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Estudiante_Carrera{" +
                "id=" + id +
                ", estudiante=" + estudiante +
                ", carrera=" + carrera +
                ", fechaInscripcion=" + fechaInscripcion +
                ", fechaGraduacion=" + fechaGraduacion +
                ", antiguedad=" + antiguedad +
                '}';
    }
}