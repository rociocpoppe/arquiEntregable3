package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;

public class MatriculacionDTO {

    @ApiModelProperty(notes="id del estudiante", name="idEstudiante", required=true, value="2")
    private Long idEstudiante;
    @ApiModelProperty(notes="id de la carrera", name="idCarrera", required=true, value="5")
    private Long idCarrera;

    

    public MatriculacionDTO(Long idEstudiante, Long idCarrera) {
        this.idEstudiante = idEstudiante;
        this.idCarrera = idCarrera;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }
 
    public Long getIdCarrera() {
        return idCarrera;
    }
 


    
    
}
