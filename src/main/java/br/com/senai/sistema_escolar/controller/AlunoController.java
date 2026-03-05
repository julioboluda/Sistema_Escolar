package br.com.senai.sistema_escolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.sistema_escolar.entity.Aluno;
import br.com.senai.sistema_escolar.exception.Response;
import br.com.senai.sistema_escolar.repository.AlunoRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;

    @PostMapping
    public Response cadastraNomeAluno(@Valid @RequestBody Aluno entity) {
        repository.save(entity);
        return new Response(201, "Aluno Registrado"); //Um novo registro foi criado com sucesso no banco de dados
    }
    
    @GetMapping
    public List<Aluno> retornaTodos() {
        return repository.findAll();
        
    }
    
     @PutMapping("/{id}")
    public Response atualizaAluno(@PathVariable Long id, @RequestBody Aluno entity) {

        if (!repository.existsById(id)) {
            return new Response(404, "Aluno não encontrado"); //Um registro não foi encontrado no banco de dados
        }

        Aluno alunoAntigo = repository.findById(id).get();

        if (entity.getNome() != null) {
            alunoAntigo.setNome(entity.getNome());
        }
        if (entity.getMatricula() != null) {
            alunoAntigo.setMatricula(entity.getMatricula());
        }
        if (entity.getNascimento() != null) {
            alunoAntigo.setNascimento(entity.getNascimento());
        }
        
             repository.save(alunoAntigo);

        return new Response(200, "Nome Aluno Atualizado!"); //sucesso na busca ou sucesso na alteração
    }


    @DeleteMapping("/{id}")
    public Response deleteAluno(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Aluno Não Encontrado"); //O recurso com o ID informado não existe ou a URL digitada está incorreta.
        }

        repository.deleteById(id);

       return new Response(204, "Aluno com Registro Deletado"); //Um registro não foi encontrado no banco de dados
    }
}
    
