package com.desafiosapcommerce.plataformacursos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

import com.desafiosapcommerce.plataformacursos.dto.InscricaoDto;
import com.desafiosapcommerce.plataformacursos.model.Inscricao;
import com.desafiosapcommerce.plataformacursos.repository.InscricaoRepository;

@Component
public class InscricaoService {

    private InscricaoRepository inscricaoRepository;

    public List<InscricaoDto> getInscricaoByAlunoId(Long alunoId) {
        try {
            List<Inscricao> entities = inscricaoRepository.findByAluno_id(alunoId);
            return entities.stream()
                    .map(inscricao -> new InscricaoDto(
                            inscricao.getId(),
                            inscricao.getAluno_id(),
                            inscricao.getCurso_id(),
                            inscricao.getDataInscricao()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Erro ao buscar inscrições do aluno: " + e.getMessage());
            return null;
        }
    }
    

    public List<InscricaoDto> getInscricoesByCursoId(Long cursoId) {
        try {
            List<Inscricao> entities = inscricaoRepository.findByCurso_id(cursoId);
            return entities.stream()
                    .map(inscricao -> new InscricaoDto(
                            inscricao.getId(),
                            inscricao.getAluno_id(),
                            inscricao.getCurso_id(),
                            inscricao.getDataInscricao()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Erro ao buscar inscrições do curso: " + e.getMessage());
            return null;
        }
    }
}
