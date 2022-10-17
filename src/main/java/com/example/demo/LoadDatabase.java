package com.example.demo;

import java.io.FileReader;
import java.sql.Timestamp;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.CarreraRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.Estudiante_CarreraRepository;

import lombok.extern.slf4j.Slf4j;

import com.example.demo.model.*;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EstudianteRepository repository, CarreraRepository cRepository, Estudiante_CarreraRepository ecRepository) {
        return args -> {
            for (CSVRecord row : CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/main/java/com/example/demo/csv/Estudiante.csv"))) {
                Long dni = Long.parseLong(row.get("nroDni"));
                String nombre = row.get("nombre");
                String apellido = row.get("apellido");
                String ciudadResidencia = row.get("ciudadResidencia");
                int edad = Integer.parseInt(row.get("edad"));
                String genero = row.get("genero");
                int nroLibreta = Integer.parseInt((row.get("nroLibretaUniv")));
                Estudiante e = new Estudiante(dni, nombre, apellido,ciudadResidencia,edad, genero, nroLibreta);
                repository.save(e);
            }
            log.info("cargados " + repository.count() + " estudiantes");
            for (CSVRecord row : CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/main/java/com/example/demo/csv/carreras.csv"))) {
                Long idCarrera = Long.parseLong(row.get("idCarrera"));
                String nombre = row.get("nombre");
                Carrera c=new Carrera(idCarrera, nombre);
                cRepository.save(c);
            }
            log.info("cargados " + cRepository.count() + " carreras");
            Estudiante e=new Estudiante((long)30, "Matías", "Perez","tandil",20,"m", 97653);
            repository.save(e);
            Carrera c=new Carrera((long)10, "arte");
            cRepository.save(c);
            Timestamp f=new Timestamp(2020-03-03);
            Estudiante_Carrera ec=new Estudiante_Carrera(e, c,f , null);
            ecRepository.save(ec);



            // for(CSVRecord row: CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/main/java/com/example/demo/csv/estudiantes_carreras.csv"))) {
            //     Long nroDni = Long.parseLong(row.get("estudiante"));
            //     Optional<Estudiante> e=repository.findById(nroDni); 
            //     Estudiante estudiante=e.get();
            //     Long idCarrera= Long.parseLong(row.get("carrera"));
            //     Optional<Carrera> c= cRepository.findById(idCarrera);
            //     Carrera carrera=c.get();
            //     Timestamp inscripcion = Timestamp.valueOf(row.get("fechaInscripcion"));
            //     Timestamp graduacion = null;
            //     if(!row.get("fechaGraduacion").equals("NULL")) {
            //         graduacion = Timestamp.valueOf(row.get("fechaGraduacion"));
            //     }              
            //     Estudiante_Carrera ec = new Estudiante_Carrera(estudiante, carrera, inscripcion, graduacion);
            //     ecRepository.save(ec);
            // }	
            // log.info("cargados " + ecRepository.count() + " estudiantes en carreras");

        };
    }

   
}