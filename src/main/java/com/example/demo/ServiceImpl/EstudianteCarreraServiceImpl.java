package com.example.demo.ServiceImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CarreraDTO;
import com.example.demo.dto.EstudianteDTO;
import com.example.demo.dto.MatriculacionDTO;
import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.model.Estudiante_Carrera;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.EstudianteCarreraRepository;
import com.example.demo.service.EstudianteCarreraService;

@Service ("EstudianteCarreraService")
public class EstudianteCarreraServiceImpl implements EstudianteCarreraService {
    
    @Autowired 
    @Qualifier("EstudianteCarreraRepository")
    private EstudianteCarreraRepository repository;
    @Autowired 
    private  EstudianteRepository estudianteRepository;
    @Autowired 
    private  CarreraRepository carreraRepository;

    // public EstudianteCarreraServiceImpl( @Qualifier("EstudianteCarreraRepository") EstudianteCarreraRepository repository,
    //     @Qualifier("CarreraRepository") CarreraRepository carreraRepository, @Qualifier("EstudianteRepository") EstudianteRepository estudianteRepository ) {
    //     this.repository = repository;
    //     this.estudianteRepository=estudianteRepository;
    //     this.carreraRepository=carreraRepository;
    // }

 
    @Override
    public List<Object[]> getReporte() {
        return repository.getReporte();
    }


    @Override
    public EstudianteDTO matricular(MatriculacionDTO matriculacion) {
        Estudiante e=estudianteRepository.getById(matriculacion.getIdEstudiante());
        System.out.println(e.getNroDni());
        Carrera c= carreraRepository.getById(matriculacion.getIdCarrera());
        System.out.println(c.getIdCarrera());
        repository.save(new Estudiante_Carrera(e,c));
        e=estudianteRepository.getById(matriculacion.getIdEstudiante());
        List<CarreraDTO>carreras=new ArrayList<>();
        e.getCarreras().forEach(carrera->{
            Carrera ca=carrera.getCarrera();
            CarreraDTO caDTO=new CarreraDTO(ca.getIdCarrera(), ca.getNombre(), c.getDuracion(), c.getEstudiantes());
            carreras.add(caDTO);
        });
        
        return new EstudianteDTO(e.getNroDni(), e.getNombre(),e.getApellido(),e.getCiudadResidencia(),e.getEdad(),e.getGenero(),e.getNroLibretaUniv(),e.getCarreras());        
    }

  
    
}
