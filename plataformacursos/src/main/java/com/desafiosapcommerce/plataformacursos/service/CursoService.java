package com.desafiosapcommerce.plataformacursos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiosapcommerce.plataformacursos.dto.CursoDto;
import com.desafiosapcommerce.plataformacursos.dto.InscricaoDto;
import com.desafiosapcommerce.plataformacursos.model.Curso;
import com.desafiosapcommerce.plataformacursos.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscricaoService inscricaoService;

    public CursoDto getById(Long id) {
        try {
            Curso entity = cursoRepository.findById(id).orElse(null);

            if (entity == null) {
                return null;
            }

            CursoDto dto = new CursoDto(entity);

            List<InscricaoDto> inscricoes = inscricaoService.getInscricoesByCursoId(id);
            dto.setInscricoes(inscricoes);
            
            return dto;
        }catch (Exception e) {
            System.out.println("Erro ao buscar curso por id: " + e.getMessage());
            return null;
        }
    }

    public List<CursoDto> getCursos() {
        try {
            List<Curso> entities = (List<Curso>) cursoRepository.findAll();
            List<CursoDto> dtos = entities.stream()
                    .map(curso -> {
                        CursoDto dto = new CursoDto(curso);
                        List<InscricaoDto> inscricoes = inscricaoService.getInscricoesByCursoId(curso.getId());
                        dto.setInscricoes(inscricoes);
                        return dto;
                    })
                    .collect(Collectors.toList());
            return dtos;
        }catch (Exception e) {
            System.out.println("Erro ao buscar cursos: " + e.getMessage());
            return null;
        }
    }

    public CursoDto getCursoByNome(String name) {
        try{
            Curso curso = cursoRepository.findByNomeIgnoreCase(name);
            if (curso != null) {
                CursoDto dto = new CursoDto(curso);
                return dto;
            }              
        }catch (Exception e) {
            System.out.println("Erro ao buscar curso por nome: " + e.getMessage());
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
