package com.desafiosapcommerce.plataformacursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiosapcommerce.plataformacursos.model.Inscricao;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

    List<Inscricao> findByAluno_id(Long aluno_id);
    List<Inscricao> findByCurso_id(Long curso_id);
}
