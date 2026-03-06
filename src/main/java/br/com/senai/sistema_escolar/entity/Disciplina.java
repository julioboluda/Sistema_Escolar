package br.com.senai.sistema_escolar.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Disciplina {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@NotBlank(message = "Disciplina precisa de um nome")
    private String nome;

@PositiveOrZero
@NotNull(message = "Precisa declarar a Carga Horária")
    private Integer carga_horaria;


@OneToMany(mappedBy = "disciplina")
    private List<Nota> nota;

@OneToMany(mappedBy = "disciplina")
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

    public Integer getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Integer carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public List<Nota> getNotas() {
        return nota;
    }

    public void setNotas(List<Nota> notas) {
        this.nota = notas;
    }

    public List<Aula> getAulas() {
        return aula;
    }

    public void setAulas(List<Aula> aulas) {
        this.aula = aulas;
    }


}
