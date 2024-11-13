package com.desafiosapcommerce.plataformacursos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "inscricao")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataInscricao;

    //Foreign keys
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno_id;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso_id;

    //Constructors
    public Inscricao() {
    }

    public Inscricao(LocalDateTime dataInscricao) {
        this.dataInscricao = LocalDateTime.now();
    }

    public Inscricao(Aluno aluno_id, Curso curso_id) {
        this.aluno_id = aluno_id;
        this.curso_id = curso_id;
        this.dataInscricao = LocalDateTime.now();
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setAluno_id(Aluno aluno_id) {
        this.aluno_id = aluno_id;
    }

    public void setCurso_id(Curso curso_id) {
        this.curso_id = curso_id;
    }

    public void setDataInscricao(LocalDateTime dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public Aluno getAluno_id() {
        return aluno_id;
    }

    public Curso getCurso_id() {
        return curso_id;
    }

    public LocalDateTime getDataInscricao() {
        return dataInscricao;
    }

    //Methods 
    @PrePersist
    public void prePersist() {
        this.dataInscricao = LocalDateTime.now();
    }

}
