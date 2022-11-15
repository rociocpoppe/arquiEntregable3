package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EstudianteDTO;
import com.example.demo.dto.MatriculacionDTO;


public interface EstudianteCarreraService {
    
    public abstract List<Object[]> getReporte();

    public abstract EstudianteDTO matricular(MatriculacionDTO c);



}