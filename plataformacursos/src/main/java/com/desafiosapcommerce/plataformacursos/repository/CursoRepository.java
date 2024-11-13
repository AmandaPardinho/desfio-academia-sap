package com.desafiosapcommerce.plataformacursos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafiosapcommerce.plataformacursos.model.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {

}
