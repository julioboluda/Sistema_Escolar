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

import br.com.senai.sistema_escolar.entity.Nota;
import br.com.senai.sistema_escolar.exception.Response;
import br.com.senai.sistema_escolar.repository.NotaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/nota")
public class NotaController {
    @Autowired
    private NotaRepository repository;

@PostMapping("path")
public Response nomeNota(@Valid @RequestBody Nota entity) {
    repository.save(entity); 
    return new Response(201, "Nota Registrada");
}

@GetMapping
public List<Nota> retornaTodos() {
    return repository.findAll();
}

@PutMapping("/{id}")
public Response atualizaNota(@PathVariable Long id, @RequestBody Nota entity) {
    
    if (!repository.existsById(id)) {
        return new Response(404, "Nota não encontrada");
    }

    Nota notaAntiga = repository.findById(id).get();
    

    if (entity.getValor_nota()!= null) {
        notaAntiga.setValor_nota(entity.getValor_nota());
    }

    if (entity.getBimestre() != null) {
        notaAntiga.setBimestre(entity.getBimestre());
    }

        repository.save(notaAntiga);
    
    return new Response(200, "Nota Atualizada");
}

@DeleteMapping("/{id}")
public Response deleteNota(@PathVariable Long id) {
    if (!repository.existsById(id)) {
        return new Response(204, "Nota não encontrada");
    }

    repository.deleteById(id);

    return new Response(204, "Nota deletada!");
    }
}