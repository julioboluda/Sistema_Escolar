package br.com.senai.sistema_escolar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Nota {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@NotNull(message = "Precisa informar a Nota")
    private Integer valor_nota;

@NotNull(message = "Precisa informar o Bimestre")
    private Integer bimestre;


@ManyToOne
@JoinColumn(name = "fk_aluno")
private Aluno aluno;

@ManyToOne
@JoinColumn(name = "fk_disciplina")
private Disciplina disciplina;    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValor_nota() {
        return valor_nota;
    }

    public void setValor_nota(Integer valor_nota) {
        this.valor_nota = valor_nota;
    }

    public Integer getBimestre() {
        return bimestre;
    }

    public void setBimestre(Integer bimestre) {
        this.bimestre = bimestre;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }



}
