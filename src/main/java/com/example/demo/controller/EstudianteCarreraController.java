package com.example.demo.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value="estudianteCarreraController", description = "Rest Api para estudianteCarrera")
public class EstudianteCarreraController {
    
    @Autowired
    @Qualifier("EstudianteCarreraService")
    private EstudianteCarreraService service;

    @ApiOperation(value="devuelve un reporte de la carrera", response= List.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message="Successful operation"),
            @ApiResponse(code= 401, message= "Check the authentication. Unauthorized"),
            @ApiResponse(code= 403, message= "Denied access. Forbidden"),
            @ApiResponse(code=404,message = "Not found")
    }
    )
    @GetMapping("/reporte")
    public List<Object[]> getReporte(){
        return service.getReporte();
    }

    @ApiOperation(value="matricula un estudiante a una carrera", response= EstudianteDTO.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message="Successful operation"),
            @ApiResponse(code= 401, message= "Check the authentication. Unauthorized"),
            @ApiResponse(code= 403, message= "Denied access. Forbidden"),
            @ApiResponse(code=404,message = "Not found")
        }
    )
    @PostMapping("/")
    public EstudianteDTO matricularEstudiante(@RequestBody MatriculacionDTO matriculacion){
        return service.matricular(matriculacion);
    }
    
}
