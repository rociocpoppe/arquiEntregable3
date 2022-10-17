package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CarreraDTO;
import com.example.demo.model.Carrera;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.service.CarreraService;


@RestController
@RequestMapping("/carreras")
public class CarreraController {
    
    
    @Autowired
    @Qualifier("CarreraService")
    private CarreraService service;


    //funciona
    @GetMapping("/")
    public List<Carrera>getCarreras(){
        return service.findAll();
    }
    
    @GetMapping("/byInscriptos")
    public List<CarreraDTO> getCarreraXEstudiantesInscriptos(){
        return service.getCarreraXEstudiantesInscriptos();
    }


    //funciona
    @PostMapping("/")
    public Carrera addCarrera(@RequestBody Carrera c){
        return service.save(c);
    }
}
