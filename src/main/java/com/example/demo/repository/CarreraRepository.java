package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Carrera;


@Repository("CarreraRepository")
public interface CarreraRepository extends JpaRepository<Carrera,Long>{

    @Query("SELECT DISTINCT c, e.size FROM Carrera c JOIN c.estudiantes e WHERE e.size > 0 ORDER BY e.size DESC")
    public List<Carrera> getCarreraXEstudiantesInscriptos();

}
