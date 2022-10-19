package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Estudiante_Carrera;

@Repository("Estudiante_CarreraRepository")
public interface Estudiante_CarreraRepository extends JpaRepository<Estudiante_Carrera,Long>{

    @Query(value = "select nombre,YEAR(anio), sum(inscriptos) as inscriptos,"
    +  " sum(graduados) as graduados from"
    +  " (SELECT c.nombre, fecha_inscripcion as anio, count(estudiante_id) as inscriptos,"
    +  " '0' as graduados from carrera c inner join  estudiante_carrera ec "
    +  " on carrera_id= c.id_carrera group by carrera_id,anio union"
    +  " SELECT c.nombre, fecha_graduacion as anio,  '0' as inscriptos, count(estudiante_id) as graduados"
    + " from carrera c inner join  estudiante_carrera ec on carrera_id= c.id_carrera "
    + " where fecha_graduacion is not null group by carrera_id,anio order by nombre,anio) a group by nombre, anio", nativeQuery = true)
   public List<Object[]> getReporte();

  

    
}
