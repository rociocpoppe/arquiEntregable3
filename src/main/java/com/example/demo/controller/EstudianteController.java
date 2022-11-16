package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.example.demo.dto.EstudianteDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(
            summary = "Devuelve todos los estudiantes",
            description = "Servicio encargado de devolver todos los estudiantes",
            tags = { "EstudianteController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public Iterable<Estudiante> getEstudiantes(){
        return service.findAll();
    }

  
    @GetMapping("/lu/{lu}")
    @Operation(
            summary = "Devuelve un estudiante según su libreta universitaria",
            description = "Servicio encargado de recuperar un estudiante, en base a su número de libreta universitaria",
            tags = { "EstudianteController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public Estudiante getEstudianteByLu(@PathVariable int lu){
        return service.getEstudianteByLU(lu);
    }

   
    @GetMapping("/genero/{genero}")
    @Operation(
            summary = "Devuelve estudiantes según su género",
            description = "Servicio encargado de recuperar todos los estudiantes, en base a su género.",
            tags = { "EstudianteController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public Iterable<Estudiante> getEstudiantesByGenero(@PathVariable String genero){
        return service.getEstudiantesByGenero(genero);
    }

    
    @GetMapping("/ciudadCarrera/{carrera}/{ciudadResidencia}")
    @Operation(
            summary = "Devuelve estudiantes de una carrera, filtrando por ciudad",
            description = "Servicio encargado de recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.",
            tags = { "EstudianteController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public Iterable<Estudiante> getEstudiantesByCarrera(@PathVariable String carrera, @PathVariable String ciudadResidencia){
        return service.getEstudiantesByCarrera(carrera, ciudadResidencia);
    }

   
    @PostMapping("/")
    @Operation(
            summary = "Da de alta a un estudiante",
            description = "Servicio encargado de dar de alta a un estudiante.",
            tags = { "EstudianteController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EstudianteDTO.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public EstudianteDTO addEstudiante(@RequestBody Estudiante e){
        return service.save(e);
    }

    
    @GetMapping("/ordenadoPorApellido/{apellido}")
    @Operation(
            summary = "Devuelve estudiantes ordenados por apellido",
            description = "Servicio encargado de devolver a todos los estudiantes ordenados por apellido.",
            tags = { "EstudianteController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
     public Iterable<Estudiante> getEstudiantesByApellido(@PathVariable("apellido") String apellido){
         return service.getEstudiantesByCriterio(apellido);
     }
    
    @GetMapping("/ordenadoPorNombre/{nombre}")
    @Operation(
            summary = "Devuelve estudiantes ordenados por nombre",
            description = "Servicio encargado de devolver a todos los estudiantes ordenados por nombre.",
            tags = { "EstudianteController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public Iterable<Estudiante> getEstudiantesByNombre(@PathVariable("nombre") String nombre){
        return service.getEstudiantesByCriterio(nombre);
    }

    
    @GetMapping("/ordenadoPorEdad/{edad}")
    @Operation(
            summary = "Devuelve estudiantes ordenados por edad",
            description = "Servicio encargado de devolver a todos los estudiantes ordenados por edad.",
            tags = { "EstudianteController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public Iterable<Estudiante> getEstudiantesByEdad(@PathVariable("edad") String edad){
        return service.getEstudiantesByCriterio(edad);
    }
}
