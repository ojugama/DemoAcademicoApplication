package co.edu.demoacademico.handler;

import co.edu.demoacademico.dto.EstudianteCreateDTO;
import co.edu.demoacademico.dto.EstudianteDTO;
import co.edu.demoacademico.dto.EstudianteUpdateDTO;
import co.edu.demoacademico.model.Estudiante;
import co.edu.demoacademico.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class EstudianteHandler {
    @Autowired
    private IEstudianteService estudianteService;

    private EstudianteDTO toDto(Estudiante estudiante) {
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setId(estudiante.getId());
        estudianteDTO.setNombre(estudiante.getNombre());
        estudianteDTO.setEmail(estudiante.getEmail());
        return estudianteDTO;
    }

    public EstudianteDTO create(EstudianteCreateDTO in) {
        Estudiante entity = new Estudiante();
        entity.setNombre(in.getNombre());
        entity.setEmail(in.getEmail());

        Estudiante savedEntity = estudianteService.create(entity);

        return toDto(savedEntity);
    }

    public EstudianteDTO findById(Long id) {
        return toDto(estudianteService.findById(id));
    }

    public Page<EstudianteDTO> findAll(Pageable pageable) {
        return estudianteService.findAll(pageable).map(this::toDto);
    }

    public EstudianteDTO update(Long id, EstudianteUpdateDTO in) {
        Estudiante entity = new Estudiante();
        entity.setNombre(in.getNombre());
        entity.setEmail(in.getEmail());

        Estudiante updatedEntity = estudianteService.update(id, entity);

        return toDto(updatedEntity);
    }

    public void delete(Long id) {
        estudianteService.delete(id);
    }
}
