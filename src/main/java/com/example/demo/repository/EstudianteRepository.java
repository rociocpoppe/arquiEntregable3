package com.example.demo.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;

@Repository ("EstudianteRepository")
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
   

    @Query ("SELECT e FROM Estudiante e WHERE e.nroLibretaUniv = :lu")
    public Estudiante getEstudianteByLU(@Param("lu")int nroLibretaUniv);

    @Query ("SELECT e FROM Estudiante e WHERE e.genero=:genero")
    public List<Estudiante> getEstudiantesByGenero(@Param("genero")String genero);

    @Query (value="SELECT * FROM estudiante ORDER BY apellido ASC", nativeQuery = true)
    public List<Estudiante> getEstudiantesByCriterioApellido();

    @Query (value="SELECT * FROM estudiante ORDER BY nombre ASC", nativeQuery = true)
    public List<Estudiante> getEstudiantesByCriterioNombre();

    @Query (value="SELECT * FROM estudiante ORDER BY edad ASC", nativeQuery = true)
    public List<Estudiante> getEstudiantesByCriterioEdad();
    
    @Query("SELECT DISTINCT(e) FROM Estudiante e JOIN e.carreras c  WHERE c.carrera.nombre = :nombre AND e.ciudadResidencia = :ciudadResidencia")
    public List <Estudiante> getEstudiantesByCarrera(@Param("nombre")String c,@Param("ciudadResidencia") String ciudad);
}
