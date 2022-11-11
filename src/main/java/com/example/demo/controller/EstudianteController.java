package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.EstudianteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value="EstudianteController", description = "Rest Api para estudiantes")
public class EstudianteController {

    
    @Autowired
    @Qualifier("EstudianteService")
    private EstudianteService service;

    @ApiOperation(value="obtiene todas los estudiantes existentes", response= Iterable.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message="Successful operation"),
            @ApiResponse(code= 401, message= "Check the authentication. Unauthorized"),
            @ApiResponse(code= 403, message= "Denied access. Forbidden"),
            @ApiResponse(code=404,message = "Not found")
        }
    )
    @GetMapping("/")
    public Iterable<Estudiante> getEstudiantes(){
        return service.findAll();
    }

    @ApiOperation(value="obtiene un estudiante según su nro de libreta universitaria", response= Estudiante.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message="Successful operation"),
            @ApiResponse(code= 401, message= "Check the authentication. Unauthorized"),
            @ApiResponse(code= 403, message= "Denied access. Forbidden"),
            @ApiResponse(code=404,message = "Not found")
        }
    )
    @GetMapping("/lu/{lu}")
    public Estudiante getEstudianteByLu(@PathVariable int lu){
        return service.getEstudianteByLU(lu);
    }

    @ApiOperation(value="obtiene estudiantes según su género", response= Iterable.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message="Successful operation"),
            @ApiResponse(code= 401, message= "Check the authentication. Unauthorized"),
            @ApiResponse(code= 403, message= "Denied access. Forbidden"),
            @ApiResponse(code=404,message = "Not found")
        }
    )
    @GetMapping("/genero/{genero}")
    public Iterable<Estudiante> getEstudiantesByGenero(@PathVariable String genero){
        return service.getEstudiantesByGenero(genero);
    }

    @ApiOperation(value="obtiene los estudiantes de una carrera en una determinada ciudad", response= Iterable.class)
    @ApiResponses(value= {
            @ApiResponse(code = 200, message = "Successful operation"),
            @ApiResponse(code = 401, message = "Check the authentication. Unauthorized"),
            @ApiResponse(code = 403, message = "Denied access. Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
        }
    )
    @GetMapping("/ciudadCarrera/{carrera}/{ciudadResidencia}")
    public Iterable<Estudiante> getEstudiantesByCarrera(@PathVariable String carrera, @PathVariable String ciudadResidencia){
        return service.getEstudiantesByCarrera(carrera, ciudadResidencia);
    }

    @ApiOperation(value="agrega un estudiante", response= EstudianteDTO.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message="Successful operation"),
            @ApiResponse(code= 401, message= "Check the authentication. Unauthorized"),
            @ApiResponse(code= 403, message= "Denied access. Forbidden"),
            @ApiResponse(code=404,message = "Not found")
        }
    )
    @PostMapping("/")
    public EstudianteDTO addEstudiante(@RequestBody Estudiante e){
        return service.save(e);
    }

    @ApiOperation(value="ordena los estudiantes por apellido", response= Iterable.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message="Successful operation"),
            @ApiResponse(code= 401, message= "Check the authentication. Unauthorized"),
            @ApiResponse(code= 403, message= "Denied access. Forbidden"),
            @ApiResponse(code=404,message = "Not found")
        }
    )
    @GetMapping("/ordenadoPorApellido/{apellido}")
     public Iterable<Estudiante> getEstudiantesByApellido(@PathVariable("apellido") String apellido){
        System.out.println("apellido ?= " + apellido);
         return service.getEstudiantesByCriterio(apellido);
     }
    @ApiOperation(value="ordena los estudiantes por nombre", response= Iterable.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message="Successful operation"),
            @ApiResponse(code= 401, message= "Check the authentication. Unauthorized"),
            @ApiResponse(code= 403, message= "Denied access. Forbidden"),
            @ApiResponse(code=404,message = "Not found")
        }
    )
    @GetMapping("/ordenadoPorNombre/{nombre}")
    public Iterable<Estudiante> getEstudiantesByNombre(@PathVariable("nombre") String nombre){
        return service.getEstudiantesByCriterio(nombre);
    }

    @ApiOperation(value="ordena los estudiantes por edad", response= Iterable.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message="Successful operation"),
            @ApiResponse(code= 401, message= "Check the authentication. Unauthorized"),
            @ApiResponse(code= 403, message= "Denied access. Forbidden"),
            @ApiResponse(code=404,message = "Not found")
        }
    )
    @GetMapping("/ordenadoPorEdad/{edad}")
    public Iterable<Estudiante> getEstudiantesByEdad(@PathVariable("edad") String edad){
        return service.getEstudiantesByCriterio(edad);
    }
}
