package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.dto.EstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Estudiante;
import com.example.demo.service.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    
    @Autowired
    @Qualifier("EstudianteService")
    private EstudianteService service;

    @GetMapping("/")
    public Iterable<Estudiante> getEstudiantes(){
        return service.findAll();
    }

    @GetMapping("/lu/{lu}")
    public Estudiante getEstudianteByLu(@PathVariable int lu){
        return service.getEstudianteByLU(lu);
    }

    @GetMapping("/genero/{genero}")
    public Iterable<Estudiante> getEstudiantesByGenero(@PathVariable String genero){
        return service.getEstudiantesByGenero(genero);
    }

    @GetMapping("/ciudadCarrera/{carrera}/{ciudadResidencia}")
    public Iterable<Estudiante> getEstudiantesByCarrera(@PathVariable String carrera, @PathVariable String ciudadResidencia){
        return service.getEstudiantesByCarrera(carrera, ciudadResidencia);
    }
  
    @PostMapping("/")
    public EstudianteDTO addEstudiante(@RequestBody Estudiante e){
        return service.save(e);
    }

    @GetMapping("/ordenadoPorApellido/{apellido}")
     public Iterable<Estudiante> getEstudiantesByApellido(@PathVariable("apellido") String apellido){
        System.out.println("apellido ?= " + apellido);
         return service.getEstudiantesByCriterio(apellido);
     }
    @GetMapping("/ordenadoPorNombre/{nombre}")
    public Iterable<Estudiante> getEstudiantesByNombre(@PathVariable("nombre") String nombre){
        return service.getEstudiantesByCriterio(nombre);
    }
    @GetMapping("/ordenadoPorEdad/{edad}")
    public Iterable<Estudiante> getEstudiantesByEdad(@PathVariable("edad") String edad){
        return service.getEstudiantesByCriterio(edad);
    }
}
