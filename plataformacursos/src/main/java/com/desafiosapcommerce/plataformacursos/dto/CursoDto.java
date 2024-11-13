package com.desafiosapcommerce.plataformacursos.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.desafiosapcommerce.plataformacursos.model.Curso;

public class CursoDto {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime dataCriacao;

    // Atributo que armazena a lista de alunos inscritos em um curso
    private List<EnrolledAlunoDTO> alunos;

    // Construtores
    public CursoDto() {
    }

    public CursoDto(Long id, String nome, String descricao, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }

    // Construtor que recebe um objeto Curso
    public CursoDto(Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.descricao = curso.getDescricao();
        this.dataCriacao = curso.getDataCriacao();
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setAlunos(List<EnrolledAlunoDTO> alunos) {
        this.alunos = alunos;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }    

    public List<EnrolledAlunoDTO> getAlunos() {
        return alunos;
    }

    // Classe interna que representa um aluno inscrito em um curso
    public static class EnrolledAlunoDTO {
        private Long aluno_id;
        private String aluno_nome;
        private LocalDateTime dataInscricao;

        // Setters
        public void setAlunoId(Long aluno_id) {
            this.aluno_id = aluno_id;
        }

        public void setAlunoNome(String aluno_nome) {
            this.aluno_nome = aluno_nome;
        }

        public void setDataInscricao(LocalDateTime dataInscricao) {
            this.dataInscricao = dataInscricao;
        }

        // Getters
        public Long getAlunoId() {
            return aluno_id;
        }

        public String getAlunoNome() {
            return aluno_nome;
        }

        public LocalDateTime getDataInscricao() {
            return dataInscricao;
        }
    }
    
}
