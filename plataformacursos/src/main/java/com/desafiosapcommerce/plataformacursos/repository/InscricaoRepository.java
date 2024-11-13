package com.desafiosapcommerce.plataformacursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiosapcommerce.plataformacursos.model.Inscricao;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

}
