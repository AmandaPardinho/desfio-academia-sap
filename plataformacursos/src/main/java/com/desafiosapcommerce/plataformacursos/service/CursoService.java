package com.desafiosapcommerce.plataformacursos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiosapcommerce.plataformacursos.dto.CursoDto;
import com.desafiosapcommerce.plataformacursos.model.Curso;
import com.desafiosapcommerce.plataformacursos.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoDto getById(Long id) {
        Curso entity = cursoRepository.findById(id).get();
        CursoDto dto = new CursoDto(entity);
        return dto;
    }

    public List<CursoDto> getCursos() {
        List<Curso> entities = (List<Curso>) cursoRepository.findAll();
        List<CursoDto> dtos = entities.stream().map(CursoDto::new).collect(Collectors.toList());
        return dtos;
    }

    public CursoDto getCursoByNome(String nome) {
        Curso curso = cursoRepository.findByNome(nome);
        if (curso != null) {
            return new CursoDto(curso);
        }                
        return null;        
    }

    public CursoDto insertCursoDto(Curso curso) {
        Curso entity = cursoRepository.save(curso);
        CursoDto dto = new CursoDto(entity);
        return dto;
    }

    public void deleteCursoDto(Curso curso) {
        cursoRepository.delete(curso);
    }
}
