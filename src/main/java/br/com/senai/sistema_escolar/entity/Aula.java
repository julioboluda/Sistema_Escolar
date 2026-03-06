package br.com.senai.sistema_escolar.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Aula {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@NotNull(message = "Precisa informar Data e Hora")
    private LocalDate data_hora;

@NotBlank(message = "Precisa declarar o conteúdo da Aula")
    private String conteudo;


@ManyToOne
@JoinColumn(name = "fk_professor")
private Professor professor;

@ManyToOne
@JoinColumn(name = "fk_disciplina")
private Disciplina disciplina;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public LocalDate getData_hora() {
    return data_hora;
}

public void setData_hora(LocalDate data_hora) {
    this.data_hora = data_hora;
}

public String getConteudo() {
    return conteudo;
}

public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
}

public Professor getProfessor() {
    return professor;
}

public void setProfessor(Professor professor) {
    this.professor = professor;
}

public Disciplina getDisciplina() {
    return disciplina;
}

public void setDisciplina(Disciplina disciplina) {
    this.disciplina = disciplina;
}



}
