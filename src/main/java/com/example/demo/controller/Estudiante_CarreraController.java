package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.model.Estudiante_Carrera;
import com.example.demo.repository.Estudiante_CarreraRepository;
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
    public Estudiante_Carrera matricularEstudiante(Estudiante_Carrera ec){
        return service.save(ec);
    }
  
      //no tira error pero trae vacio cuando deberia tener algo
    //   @GetMapping("/ciudadCarrera/{carrera}/{ciudadResidencia}")
    //   public Iterable<Estudiante> getEstudiantesByCarrera(@PathVariable String carrera, @PathVariable String ciudadResidencia){
    //       return service.getEstudiantesByCarrera(carrera, ciudadResidencia);
    //   }
}
