package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Estudiante_Carrera;
import com.example.demo.repository.Estudiante_CarreraRepository;
import com.example.demo.service.Estudiante_CarreraService;


@RestController
@RequestMapping("/estudiantesCarreras")
public class Estudiante_CarreraController {
    
    @Autowired
    @Qualifier("Estudiante_CarreraService")
    private Estudiante_CarreraService service;

    @PostMapping("/")
    public Estudiante_Carrera addCarrera(@RequestBody Estudiante_Carrera c){
        return service.save(c);
    }

    @GetMapping("/")
    public List<Object[]> getReporte(){
        return service.getReporte();
    }

}
