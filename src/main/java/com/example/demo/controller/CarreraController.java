package com.example.demo.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api (value="CarreraController", description = "Rest Api para carreras")
public class CarreraController {
    
    
    @Autowired
    @Qualifier("CarreraService")
    private CarreraService service;


    @ApiOperation(value="obtiene todas las carreras existentes", response= List.class)
    @ApiResponses(value={
                @ApiResponse(code=200, message="Successful operation"),
                @ApiResponse(code= 401, message= "Check the authentication. Unauthorized"),
                @ApiResponse(code= 403, message= "Denied access. Forbidden"),
                @ApiResponse(code=404,message = "Not found")
            }

    )
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

    @ApiOperation(value="obtiene las carreras por estudiantes inscriptos", response= List.class)
    @ApiResponses(value={
        @ApiResponse(code=200, message="Successful operation"),
        @ApiResponse(code= 401, message= "Check the authentication. Unauthorized"),
        @ApiResponse(code= 403, message= "Denied access. Forbidden"),
        @ApiResponse(code=404,message = "Not found")
        }
    )
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
