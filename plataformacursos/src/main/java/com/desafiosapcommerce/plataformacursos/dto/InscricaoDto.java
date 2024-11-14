package com.desafiosapcommerce.plataformacursos.dto;

import java.time.LocalDateTime;

import com.desafiosapcommerce.plataformacursos.model.Aluno;
import com.desafiosapcommerce.plataformacursos.model.Curso;

public class InscricaoDto {
    
    private Long id;
    private Aluno aluno_id;
    private Curso curso_id;
    private LocalDateTime dataInscricao;

    // Construtores
    public InscricaoDto() {
    }

    public InscricaoDto(Long id, Aluno aluno_id, Curso curso_id, LocalDateTime dataInscricao) {
        this.id = id;
        this.aluno_id = aluno_id;
        this.curso_id = curso_id;
        this.dataInscricao = dataInscricao;
    }

    // Setters
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

    // Getters
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
}
