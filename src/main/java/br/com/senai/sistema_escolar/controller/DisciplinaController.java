package br.com.senai.sistema_escolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.sistema_escolar.entity.Disciplina;
import br.com.senai.sistema_escolar.exception.Response;
import br.com.senai.sistema_escolar.repository.DisciplinaRepository;
import jakarta.validation.Valid;


  
@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
    @Autowired
    private DisciplinaRepository repository;

@PostMapping("path")
public Response nomeDisciplina(@Valid @RequestBody Disciplina entity) {
    repository.save(entity); 
    return new Response(201, "Disciplina Registrada");
}

@GetMapping
public List<Disciplina> retornaTodos() {
    return repository.findAll();
}

@PutMapping("/{id}")
public Response atualizaDisciplina(@PathVariable Long id, @RequestBody Disciplina entity) {
    
    if (!repository.existsById(id)) {
        return new Response(404, "Disciplina não encontrada");
    }

    Disciplina disciplinaAntiga = repository.findById(id).get();
    

    if (entity.getNome()!= null) {
        disciplinaAntiga.setNome(entity.getNome());
    }

    if (entity.getCarga_horaria() != null) {
        disciplinaAntiga.setCarga_horaria(entity.getCarga_horaria());
    }

        repository.save(disciplinaAntiga);
    
    return new Response(200, "Disciplina Atualizada");
}

@DeleteMapping("/{id}")
public Response deleteDisciplina(@PathVariable Long id) {
    if (!repository.existsById(id)) {
        return new Response(204, "Disciplina não encontrada");
    }

    repository.deleteById(id);

    return new Response(204, "Disciplina deletada!");
    }
}
