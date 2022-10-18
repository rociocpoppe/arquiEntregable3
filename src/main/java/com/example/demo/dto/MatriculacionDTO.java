package com.example.demo.dto;

public class MatriculacionDTO {

    private Long idEstudiante;
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
