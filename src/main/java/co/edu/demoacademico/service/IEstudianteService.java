package co.edu.demoacademico.service;

import co.edu.demoacademico.model.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEstudianteService {
    Estudiante create(Estudiante estudiante);

    Estudiante findById(Long id);

    Page<Estudiante> findAll(Pageable pageable);

    Estudiante update(Long id, Estudiante estudiante);

    void delete(Long id);
}
