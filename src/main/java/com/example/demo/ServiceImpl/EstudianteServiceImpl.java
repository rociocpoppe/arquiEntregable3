package com.example.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.service.EstudianteService;

import org.springframework.data.domain.Sort;

@Service ("EstudianteService")
public class EstudianteServiceImpl implements EstudianteService{
    
    @Autowired
    @Qualifier("EstudianteRepository")
    private final EstudianteRepository repository;

    
    public EstudianteServiceImpl(EstudianteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estudiante> getEstudiantesByCriterio( String orden){
        System.out.println(orden);
        List<Estudiante> lista=new ArrayList<>();
        if (orden.equals("nombre")) {
            return lista.stream().sorted(Comparator.comparing(Estudiante::getNombre)).collect(Collectors.toList());
        }else if (orden.equals("apellidos")) {
        
        return lista.stream().sorted(Comparator.comparing(Estudiante::getApellido)).collect(Collectors.toList());
        }else {
        
        return lista.stream().sorted(Comparator.comparing(Estudiante::getEdad)).collect(Collectors.toList());
        }    
    }
        //         public Iterable<Estudiante> getEstudiantesByCriterio(@PathParam("apellido") String nombre){
        //         return service.getEstudiantesByCriterio(nombre);
        //     }
        //         return repository.getEstudiantesByCriterio(criterio);
        // }
        
        
    //     return repository.getEstudiantesByCriterio(orden);
    // }
    
    @Override
    public Estudiante getEstudianteByLU(int nroLibretaUniv) {
        return repository.getEstudianteByLU(nroLibretaUniv);
    }

    @Override
    public List<Estudiante> getEstudiantesByGenero(String genero) {
        return repository.getEstudiantesByGenero(genero);
    }

    @Override
    public List<Estudiante> getEstudiantesByCarrera(String c, String ciudad) {
        return repository.getEstudiantesByCarrera(c, ciudad);
    }

    @Override
    public Iterable<Estudiante> findAll() {
        return repository.findAll();
    }

    @Override
    public Estudiante save(Estudiante e) {
        return repository.save(null);
    }

    @Override
    public Optional<Estudiante> findById(Long dni) {
        return repository.findById(dni);
    }
}
