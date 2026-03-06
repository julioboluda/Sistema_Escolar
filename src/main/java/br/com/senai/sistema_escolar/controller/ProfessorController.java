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

import br.com.senai.sistema_escolar.entity.Professor;
import br.com.senai.sistema_escolar.exception.Response;
import br.com.senai.sistema_escolar.repository.ProfessorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Professor")
public class ProfessorController {
    @Autowired
    private ProfessorRepository repository;

@PostMapping("path")
public Response nomeProfessor(@Valid @RequestBody Professor entity) {
    repository.save(entity); 
    return new Response(201, "Professor Registrado");
}

@GetMapping
public List<Professor> retornaTodos() {
    return repository.findAll();
}

@PutMapping("/{id}")
public Response atualizaProfessor(@PathVariable Long id, @RequestBody Professor entity) {
    
    if (!repository.existsById(id)) {
        return new Response(404, "Professor não encontrado");
    }

    Professor professorAntigo = repository.findById(id).get();
    

    if (entity.getNome()!= null) {
        professorAntigo.setNome(entity.getNome());
    }

    if (entity.getEmail() != null) {
        professorAntigo.setEmail(entity.getEmail());
    }

    if (entity.getTitulacao() != null) {
        professorAntigo.setTitulacao(entity.getTitulacao());
    }

        repository.save(professorAntigo);
    
    return new Response(200, "Professor Atualizado");
}

@DeleteMapping("/{id}")
public Response deleteProfessor(@PathVariable Long id) {
    if (!repository.existsById(id)) {
        return new Response(204, "Professor não encontrado");
    }

    repository.deleteById(id);

    return new Response(204, "Professor deletado!");
    }
}