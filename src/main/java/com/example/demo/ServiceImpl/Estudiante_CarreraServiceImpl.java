package com.example.demo.ServiceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.model.Estudiante_Carrera;
import com.example.demo.repository.Estudiante_CarreraRepository;
import com.example.demo.service.Estudiante_CarreraService;

@Service ("Estudiante_CarreraService")
public class Estudiante_CarreraServiceImpl implements Estudiante_CarreraService{
    
    @Autowired 
    @Qualifier("Estudiante_CarreraRepository")
    private final Estudiante_CarreraRepository repository;

    public Estudiante_CarreraServiceImpl( @Qualifier("Estudiante_CarreraRepository") Estudiante_CarreraRepository repository) {
        this.repository = repository;
    }

 
    @Override
    public List<Object[]> getReporte() {
        return repository.getReporte();
    }


    @Override
    public Estudiante_Carrera save(Estudiante_Carrera c) {
        return repository.save(c);
    }

    // @Override
    // public List<Estudiante> getEstudiantesByCarrera(String c, String ciudad) {
    //     return repository.getEstudiantesByCarrera(c, ciudad);
    // }
 

   
    
}
