package com.desafiosapcommerce.plataformacursos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafiosapcommerce.plataformacursos.model.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

}
