package co.edu.demoacademico.repository;

import co.edu.demoacademico.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Boolean existsByEmail(String email);

    Boolean existsByEmailAndIdNot(String email, Long id);
}
