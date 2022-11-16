package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Estudiante_Carrera;

@Repository("EstudianteCarreraRepository")
public interface EstudianteCarreraRepository extends JpaRepository<Estudiante_Carrera,Long>{

    @Query(value = "select nombre, anio, sum(inscriptos) as inscriptos,\n" +
            "    sum(graduados) as graduados from\n" +
            " (SELECT c.nombre, EXTRACT(YEAR FROM fecha_inscripcion) as anio, count(estudiante_id) as inscriptos,\n" +
            "     '0' as graduados from carrera c inner join  estudiante_carrera ec\n" +
            "     on carrera_id= c.id_carrera group by carrera_id,anio, c.nombre union\n" +
            "     SELECT c.nombre, EXTRACT(YEAR FROM fecha_graduacion) as anio,  '0' as inscriptos, count(estudiante_id) as graduados\n" +
            "     from carrera c inner join  estudiante_carrera ec on carrera_id= c.id_carrera\n" +
            "     where fecha_graduacion is not null group by carrera_id,anio, c.nombre order by nombre,anio) a group by nombre, anio", nativeQuery = true)
   public List<Object[]> getReporte();

  

    
}
