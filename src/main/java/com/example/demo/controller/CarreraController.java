package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CarreraDTO;
import com.example.demo.model.Carrera;
import com.example.demo.service.CarreraService;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
    
    
    @Autowired
    @Qualifier("CarreraService")
    private CarreraService service;


    @GetMapping("/")
    @Operation(
            summary = "Devuelve el listado de carreras",
            description = "Servicio encargado de devolver el listado de carreras disponibles.",
            tags = { "CarreraController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrera.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public List<Carrera>getCarreras(){
        return service.findAll();
    }
    

    @RequestMapping(value = "/byInscriptos",method = RequestMethod.GET, produces = "application/json")
    @Operation(
            summary = "Devuelve el listado de las carreras con estudiantes inscriptos, y ordena por cantidad de inscriptos.",
            description = "Servicio encargado de devolver el listado de las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.",
            tags = { "CarreraController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CarreraDTO.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public List<CarreraDTO> getCarrerasPorInscriptos(){
      return  service.getCarreraXEstudiantesInscriptos();
    }
}
