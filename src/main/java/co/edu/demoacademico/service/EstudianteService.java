package co.edu.demoacademico.service;

import co.edu.demoacademico.model.Estudiante;
import co.edu.demoacademico.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante create(Estudiante estudiante){
        // =====================================
        // ZONA DE LÓGICA DE NEGOCIO:
        // Regla: email único
        // =====================================

        estudianteRepository.findByEmail(estudiante.getEmail())
                .ifPresent(e -> {
                    throw new IllegalStateException("Email ya registrado.");
                });

        // =====================================
        // ZONA DE ACCESO A LA BD:
        // Persistencia vía repository
        // =====================================

        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> findAll() {
        // =====================================
        // ZONA DE ACCESO A LA BD:
        // Persistencia vía repository
        // =====================================

        return estudianteRepository.findAll();
    }

}
