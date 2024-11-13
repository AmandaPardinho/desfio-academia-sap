package com.desafiosapcommerce.plataformacursos.dto;

import java.time.LocalDateTime;

import com.desafiosapcommerce.plataformacursos.model.Aluno;

public class AlunoDto {

    private Long id;
    private String nome;
    private String email;
    private LocalDateTime dataCadastro;

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
}