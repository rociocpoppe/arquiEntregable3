package com.example.demo.ServiceImpl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CarreraDTO;
import com.example.demo.dto.EstudianteDTO;
import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.service.CarreraService;

@Service("CarreraService")
public class CarreraServiceImpl implements CarreraService{

    @Autowired
    @Qualifier("CarreraRepository")
    private final CarreraRepository repository;


    public CarreraServiceImpl(@Qualifier("CarreraRepository")CarreraRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public List<CarreraDTO> getCarreraXEstudiantesInscriptos() {
        List<Carrera> carreras=repository.getCarreraXEstudiantesInscriptos();
        LinkedList<CarreraDTO> carrerasDto =  new LinkedList<>();
        for(Carrera c: carreras){
            LinkedList<EstudianteDTO> students = new LinkedList<>();
            c.getEstudiantes().forEach(estudiante -> {
                Estudiante e = estudiante.getEstudiante();
                EstudianteDTO estudianteDTO = new EstudianteDTO(e.getNroDni(),e.getNombre(),e.getApellido()
                    ,e.getEdad(),e.getGenero(),e.getCiudadResidencia(),e.getNroLibretaUniv(),e.getCarreras());
                students.add(estudianteDTO);
            });
        CarreraDTO carreraDto = new CarreraDTO(c.getIdCarrera(), c.getNombre(), c.getDuracion(), c.getEstudiantes());
        carrerasDto.add(carreraDto);
        }
     return carrerasDto;
    }

    @Override
    public Carrera save(Carrera c) {
        return repository.save(c);
    }

    @Override
    public List<Carrera> findAll() {
        return repository.findAll();
    }
    
}
