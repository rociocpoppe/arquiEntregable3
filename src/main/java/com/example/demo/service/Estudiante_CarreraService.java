package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.model.Estudiante_Carrera;

public interface Estudiante_CarreraService {
    
    public abstract List<Object[]> getReporte();

    public abstract Estudiante_Carrera save(Estudiante_Carrera c);

   // public abstract List <Estudiante> getEstudiantesByCarrera(String c, String ciudad);
}
