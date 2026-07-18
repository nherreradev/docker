package com.consultora;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaRepository repository;

    public PersonaController(PersonaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Persona crear() {
        Persona persona = new Persona(
                "Nicolas",
                "nico@test.com"
        );
        return repository.save(persona);
    }

    @GetMapping
    public List<Persona> listar() {
        return repository.findAll();
    }
}
