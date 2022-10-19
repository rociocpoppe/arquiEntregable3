package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EstudianteDTO;
import com.example.demo.dto.MatriculacionDTO;
import com.example.demo.service.Estudiante_CarreraService;


@RestController
@RequestMapping("/estudiantesCarreras")
public class Estudiante_CarreraController {
    
    @Autowired
    @Qualifier("Estudiante_CarreraService")
    private Estudiante_CarreraService service;

    @GetMapping("/reporte")
    public List<Object[]> getReporte(){
        return service.getReporte();
    }

    @PostMapping("/")
    public EstudianteDTO matricularEstudiante(@RequestBody MatriculacionDTO matriculacion){
        return service.matricular(matriculacion);
    }
    
}
