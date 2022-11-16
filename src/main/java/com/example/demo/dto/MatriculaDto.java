package com.example.demo.dto;


public class MatriculaDto {

    private Long idEstudiante;
    private Long idCarrera;

    

    public MatriculaDto(Long idEstudiante, Long idCarrera) {
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
