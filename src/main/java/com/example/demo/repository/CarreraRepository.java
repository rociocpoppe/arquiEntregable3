package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.ServiceImpl.CarreraDTO;
import com.example.demo.model.Carrera;

@Repository("CarreraRepository")
public interface CarreraRepository extends JpaRepository<Carrera,Long>{

    @Query("SELECT c.nombre,count(e) as contador FROM Carrera c "
    + "JOIN c.estudiantes e "
    + "WHERE c.estudiantes IS NOT EMPTY "
    + "GROUP BY c.nombre "
    + "ORDER BY contador DESC")
    public List<Carrera> getCarreraXEstudiantesInscriptos();
}
