package br.com.senai.sistema_escolar.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Professor {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@NotBlank(message = "Professor precisa de um nome")
    private String nome;

@NotBlank(message = "Precisa informar um email")
    private String email;

@NotBlank(message = "Professor precisa informar Titulação")
    private String titulacao;


@OneToMany(mappedBy = "professor")
    private List<Disciplina> disciplina;

@OneToMany(mappedBy = "professor")
    private List<Aula> aula; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public List<Disciplina> getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(List<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }

    public List<Aula> getAula() {
        return aula;
    }

    public void setAula(List<Aula> aula) {
        this.aula = aula;
    }



}
