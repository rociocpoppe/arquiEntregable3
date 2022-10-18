package com.example.demo.repository;


import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;

@Repository ("EstudianteRepository")
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
   
    //funciona
    @Query ("SELECT e FROM Estudiante e WHERE e.nroLibretaUniv = :lu")
    public Estudiante getEstudianteByLU(@Param("lu")int nroLibretaUniv);

    //funciona
    @Query ("SELECT e FROM Estudiante e WHERE e.genero=:genero")
    public List<Estudiante> getEstudiantesByGenero(@Param("genero")String genero);

    //funciona
    @Query (value="SELECT * FROM estudiante ORDER BY apellido ASC", nativeQuery = true)
    public List<Estudiante> getEstudiantesByCriterioApellido();

    //funciona
    @Query (value="SELECT * FROM estudiante ORDER BY nombre ASC", nativeQuery = true)
    public List<Estudiante> getEstudiantesByCriterioNombre();

    //funciona
    @Query (value="SELECT * FROM estudiante ORDER BY edad ASC", nativeQuery = true)
    public List<Estudiante> getEstudiantesByCriterioEdad();
    
    //funciona
    @Query(value="select * from estudiante e join estudiante_carrera EC join carrera C on id_carrera = carrera_id where e.ciudad_residencia=:ciudadResidencia and C.nombre=:nombre", nativeQuery=true)
    public List <Estudiante> getEstudiantesByCarrera(@Param("nombre")String c,@Param("ciudadResidencia") String ciudad);
}
