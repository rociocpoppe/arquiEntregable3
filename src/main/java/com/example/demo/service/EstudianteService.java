package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;

public interface EstudianteService {

    public abstract List<Estudiante> getEstudiantesByCriterio(String criterio);
    
    public abstract Estudiante getEstudianteByLU(int nroLibretaUniv);

    public abstract List<Estudiante> getEstudiantesByGenero(String genero);

    public abstract List <Estudiante> getEstudiantesByCarrera(String c, String ciudad);
    
    public abstract Iterable<Estudiante> findAll();

    public abstract Estudiante save(Estudiante e);

    public abstract Optional<Estudiante> findById(Long dni);


}
