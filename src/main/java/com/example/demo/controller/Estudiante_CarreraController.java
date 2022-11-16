package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.CarreraDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EstudianteDTO;
import com.example.demo.dto.MatriculacionDTO;
import com.example.demo.service.EstudianteCarreraService;


@RestController
@RequestMapping("/estudiantesCarreras")
public class Estudiante_CarreraController {
    
    @Autowired
    @Qualifier("EstudianteCarreraService")
    private EstudianteCarreraService service;

    @GetMapping("/reporte")
    @Operation(
            summary = "Genera un reporte de las carreras",
            description = "Servicio encargado de generar un reporte de las carreras, con  información de los\n" +
                    "inscriptos y egresados por año, ordenadas alfabéticamente, con años de manera cronológica.",
            tags = { "EstudianteCarreraController" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = List.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public List<Object[]> getReporte(){
        return service.getReporte();
    }

    @PostMapping("/")
    @Operation(
            summary = "Matricula un estudiante a una carrera",
            description = "Servicio encargado de matricular un estudiante a una carrera",
            tags = { "EstudianteCarreraController" },
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
    public EstudianteDTO matricularEstudiante(@RequestBody MatriculacionDTO matriculacion){
        return service.matricular(matriculacion);
    }
    
}