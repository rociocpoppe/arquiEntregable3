package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.model.Estudiante_Carrera;

@Repository("Estudiante_CarreraRepository")
public interface Estudiante_CarreraRepository extends JpaRepository<Estudiante_Carrera,Long>{

    @Query(value = "select nombre,YEAR(anio), sum(inscriptos) as inscriptos,"
    +  " sum(graduados) as graduados from"
    +  " (SELECT c.nombre, fechaInscripcion as anio, count(estudianteId) as inscriptos,"
    +  " '0' as graduados from Carrera c inner join  Estudiante_Carrera ec "
    +  " on carreraId= c.idCarrera group by carreraId,anio union"
    +  " SELECT c.nombre, fechaGraduacion as anio,  '0' as inscriptos, count(estudianteId) as graduados"
    + " from Carrera c inner join  Estudiante_Carrera ec on carreraId= c.idCarrera "
    + " where fechaGraduacion is not null group by carreraId,anio order by nombre,anio) a group by nombre, anio", nativeQuery = true)
   public List<Object[]> getReporte();
    
}
