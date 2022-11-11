package com.example.demo.ServiceImpl;


import java.util.List;
import java.util.Optional;


import com.example.demo.dto.EstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.service.EstudianteService;


@Service ("EstudianteService")
public class EstudianteServiceImpl implements EstudianteService{
    
    @Autowired
    @Qualifier("EstudianteRepository")
    private  EstudianteRepository repository;

    
    // public EstudianteServiceImpl(EstudianteRepository repository) {
    //     this.repository = repository;
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
    public Iterable<Estudiante> findAll() {
        return repository.findAll();
    }

    @Override
    public EstudianteDTO save(Estudiante e) {
        Estudiante estudiante=new Estudiante(e.getNroDni(), 
        e.getNombre(), e.getApellido(),
         e.getCiudadResidencia(), e.getEdad(), 
         e.getGenero(),e.getNroLibretaUniv());
        repository.save(estudiante);
        EstudianteDTO estudianteDto=new EstudianteDTO(estudiante.getNroDni(),
        estudiante.getNombre(),estudiante.getApellido(),
        estudiante.getCiudadResidencia(),
        estudiante.getEdad(),estudiante.getGenero(),
        estudiante.getNroLibretaUniv());
        return estudianteDto;
    }

    @Override
    public Optional<Estudiante> findById(Long dni) {
        return repository.findById(dni);
    }

    public List<Estudiante> getEstudiantesByCriterio( String orden){
        System.out.println("orden = " + orden);
        if (orden.equals("nombre")) {
            return repository.getEstudiantesByCriterioNombre();
        }else  if (orden.equals("apellido")) {
            return repository.getEstudiantesByCriterioApellido();
        }else {
            return repository.getEstudiantesByCriterioEdad();
        }
    }

    @Override
    public List<Estudiante> getEstudiantesByCarrera(String c, String ciudad) {
        return repository.getEstudiantesByCarrera(c, ciudad);
    }
}
