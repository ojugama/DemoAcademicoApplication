package co.edu.demoacademico.controller;

import co.edu.demoacademico.model.Estudiante;
import co.edu.demoacademico.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public Estudiante create(@Valid @RequestBody Estudiante estudiante) {
        return estudianteService.create(estudiante);
    }

    @GetMapping
    public List<Estudiante> findAll() {
        return  estudianteService.findAll();
    }

}
