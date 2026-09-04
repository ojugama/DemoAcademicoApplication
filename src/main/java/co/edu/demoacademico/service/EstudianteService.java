package co.edu.demoacademico.service;

import co.edu.demoacademico.exception.BusinessException;
import co.edu.demoacademico.exception.NotFoundException;
import co.edu.demoacademico.model.Estudiante;
import co.edu.demoacademico.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstudianteService implements IEstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public Estudiante create(Estudiante estudiante) {
        if (estudianteRepository.existsByEmail(estudiante.getEmail())) {
            throw new BusinessException("Ya existe un estudiante con el email: " + estudiante.getEmail() + ".");
        }

        return estudianteRepository.save(estudiante);
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante findById(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con id: " + id + "."));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Estudiante> findAll(Pageable pageable) {
        return estudianteRepository.findAll(pageable);
    }

    @Override
    public Estudiante update(Long id, Estudiante estudiante) {
        Estudiante existingEstudiante = findById(id);

        if (estudianteRepository.existsByEmailAndIdNot(estudiante.getEmail(), id)) {
            throw new BusinessException("Ya existe otro estudiante con el email: " + estudiante.getEmail() + ".");
        }

        existingEstudiante.setNombre(estudiante.getNombre());
        existingEstudiante.setEmail(estudiante.getEmail());

        return estudianteRepository.save(existingEstudiante);
    }

    @Override
    public void delete(Long id) {
        Estudiante existingEstudiante = findById(id);
        estudianteRepository.delete(existingEstudiante);
    }
}
