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

import br.com.senai.sistema_escolar.entity.Aula;
import br.com.senai.sistema_escolar.exception.Response;
import br.com.senai.sistema_escolar.repository.AulaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aula")
public class AulaController {
    @Autowired
    private AulaRepository repository;

@PostMapping("path")
public Response nomeAula(@Valid @RequestBody Aula entity) {
    repository.save(entity); 
    return new Response(201, "Aula Registrada");
}

@GetMapping
public List<Aula> retornaTodos() {
    return repository.findAll();
}

@PutMapping("/{id}")
public Response atualizaAula(@PathVariable Long id, @RequestBody Aula entity) {
    
    if (!repository.existsById(id)) {
        return new Response(404, "Aula não encontrada");
    }

    Aula aulaAntiga = repository.findById(id).get();
    

    if (entity.getData_hora()!= null) {
        aulaAntiga.setData_hora(entity.getData_hora());
    }

    if (entity.getConteudo() != null) {
        aulaAntiga.setConteudo(entity.getConteudo());
    }

        repository.save(aulaAntiga);
    
    return new Response(200, "Aula Atualizada");
}

@DeleteMapping("/{id}")
public Response deleteAula(@PathVariable Long id) {
    if (!repository.existsById(id)) {
        return new Response(204, "Aula não encontrada");
    }

    repository.deleteById(id);

    return new Response(204, "Aula deletada!");
    }
}

