package com.desafiosapcommerce.plataformacursos.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "curso_id", orphanRemoval = true)
    private List<Inscricao> inscricoes = new ArrayList<>();

    //Constructors
    public Curso() {
    }

    public Curso(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    //Setters
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

    //Getters
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

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    // Methods
    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }

    public void addAluno(Aluno aluno) {
        Inscricao inscricao = new Inscricao(aluno, this);
        inscricoes.add(inscricao);
        aluno.getInscricoes().add(inscricao);
    }
}
