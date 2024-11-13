package com.desafiosapcommerce.plataformacursos.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private LocalDateTime dataCadastro;
    
    @OneToMany(mappedBy = "aluno_id", orphanRemoval = true)
    private List<Inscricao> inscricoes = new ArrayList<>();

    //Constructors
    public Aluno() {
    }

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    //Setters
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

    //Getters
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

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    // Methods
    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDateTime.now();
    }

    public void addCurso(Curso curso) {
        Inscricao inscricao = new Inscricao(this, curso);
        inscricoes.add(inscricao);
        curso.getInscricoes().add(inscricao);
    }
}
