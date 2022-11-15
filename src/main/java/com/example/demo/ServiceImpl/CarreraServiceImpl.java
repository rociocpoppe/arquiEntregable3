package com.example.demo.ServiceImpl;

import java.util.ArrayList;
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
    private CarreraRepository repository;


    // public CarreraServiceImpl(@Qualifier("CarreraRepository")CarreraRepository repository) {
    //     this.repository = repository;
    // }
    
        
    @Override
    public List<CarreraDTO> getCarreraXEstudiantesInscriptos() {
        List<Carrera> car=repository.getCarreraXEstudiantesInscriptos();
        List<CarreraDTO> carrerasDTO = new ArrayList<>();
        car.forEach(c->{
            List<EstudianteDTO>estudiantes=new ArrayList<>();
            c.getEstudiantes().forEach(estudiante->{
                Estudiante e = estudiante.getEstudiante();
                EstudianteDTO estudianteDTO = new EstudianteDTO(e.getNroDni(),e.getNombre(),e.getApellido()
                    ,e.getCiudadResidencia(),e.getEdad(),e.getGenero(),e.getNroLibretaUniv(),e.getCarreras());
                estudiantes.add(estudianteDTO);
            });
            CarreraDTO carreraDto = new CarreraDTO(c.getIdCarrera(),c.getNombre(), c.getDuracion(), c.getEstudiantes().size());
            carrerasDTO.add(carreraDto);
        });         
     return carrerasDTO;
    }


    @Override
    public List<Carrera> findAll() {
        return repository.findAll();
    }

}
