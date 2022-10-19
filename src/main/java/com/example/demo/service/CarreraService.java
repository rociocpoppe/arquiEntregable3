package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.CarreraDTO;
import com.example.demo.model.Carrera;


public interface CarreraService {

    public abstract List<CarreraDTO> getCarreraXEstudiantesInscriptos();

    public abstract List<Carrera> findAll();

}
