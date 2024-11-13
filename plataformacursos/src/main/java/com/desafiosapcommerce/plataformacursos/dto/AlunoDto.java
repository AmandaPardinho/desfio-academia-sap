package com.desafiosapcommerce.plataformacursos.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.desafiosapcommerce.plataformacursos.model.Aluno;

public class AlunoDto {

    private Long id;
    private String nome;
    private String email;
    private LocalDateTime dataCadastro;

    // Atributo que armazena a lista de inscrições de um curso
    private List<InscricaoCursoDTO> cursos;

    // Construtores
    public AlunoDto() {
    }

    public AlunoDto(Long id, String nome, String email, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    // Construtor que recebe um objeto Aluno 
    public AlunoDto(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.dataCadastro = aluno.getDataCadastro();
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setCursos(List<InscricaoCursoDTO> cursos) {
        this.cursos = cursos;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public List<InscricaoCursoDTO> getCursos() {
        return cursos;
    }

    // Classe interna que representa a inscrição de um curso
    public static class InscricaoCursoDTO {
        private Long curso_id;
        private String curso_nome;
        private LocalDateTime dataInscricao;

        // Setters
        public void setCursoId(Long curso_id) {
            this.curso_id = curso_id;
        }

        public void setCursoNome(String curso_nome) {
            this.curso_nome = curso_nome;
        }

        public void setDataInscricao(LocalDateTime dataInscricao) {
            this.dataInscricao = dataInscricao;
        }

        // Getters
        public Long getCursoId() {
            return curso_id;
        }

        public String getCursoNome() {
            return curso_nome;
        }

        public LocalDateTime getDataInscricao() {
            return dataInscricao;
        }
    }
}
