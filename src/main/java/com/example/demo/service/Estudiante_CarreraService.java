package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EstudianteDTO;
import com.example.demo.dto.MatriculacionDTO;
import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.model.Estudiante_Carrera;

public interface Estudiante_CarreraService {
    
    public abstract List<Object[]> getReporte();

    public abstract EstudianteDTO matricular(MatriculacionDTO c);



}
