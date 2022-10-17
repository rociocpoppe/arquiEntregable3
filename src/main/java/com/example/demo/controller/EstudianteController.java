package com.example.demo.controller;




import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.service.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    
    @Autowired
    @Qualifier("EstudianteService")
    private EstudianteService service;


    //funciona
    @GetMapping("/")
    public Iterable<Estudiante> getEstudiantes(){
        return service.findAll();
    }


    //no funciona
    @GetMapping("/id/{id}")
    public Optional<Estudiante> getEstudianteById(Long dni){
        return service.findById(dni);
    }
        

    //no funcionaaaa    
    //@GetMapping("/apellido/{apellido}")
    // public Iterable<Estudiante> getEstudiantesByCriterio(@PathParam("apellido") String nombre){
    //     return service.getEstudiantesByCriterio(nombre);
    // }

   @RequestMapping(value ="/criterio" , params="orden",method = RequestMethod.GET, produces = "application/json")
   @ResponseBody 
   //@GetMapping("/criterio")
    public Iterable<Estudiante> getEstudiantesByCriterio(@RequestParam (defaultValue = "nombre" ) String cr){
        System.out.println("este es el param " + cr);
        return service.getEstudiantesByCriterio(cr);
    }

    //funciona
    @GetMapping("/lu/{lu}")
    public Estudiante getEstudianteByLu(@PathVariable int lu){
        return service.getEstudianteByLU(lu);
    }

    //funciona
    @GetMapping("/genero/{genero}")
    public Iterable<Estudiante> getEstudiantesByGenero(@PathVariable String genero){
        return service.getEstudiantesByGenero(genero);
    }


    //no tira error pero trae vacio cuando deberia tener algo
    @GetMapping("/ciudadCarrera/{carrera}/{ciudadResidencia}")
    public Iterable<Estudiante> getEstudiantesByCarrera(@PathVariable String carrera, @PathVariable String ciudadResidencia){
        return service.getEstudiantesByCarrera(carrera, ciudadResidencia);
    }
    
    @PostMapping("/")
    public Estudiante addEstudiante(@RequestBody Estudiante e){
        return service.save(e);
    }

    
}
