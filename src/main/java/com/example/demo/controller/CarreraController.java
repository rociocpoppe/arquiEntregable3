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
    public List<CarreraDTO> getCarrerasPorInscriptos(){
      return  service.getCarreraXEstudiantesInscriptos();
    }
}
