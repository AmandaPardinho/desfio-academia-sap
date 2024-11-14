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

    public List<InscricaoDto> getInscricaoByAlunoId(Long aluno_id) {
        List<Inscricao> entities = inscricaoRepository.findByAluno_id(aluno_id);
        return entities.stream()
                .map(inscricao -> new InscricaoDto(
                    inscricao.getId(),
                    inscricao.getAluno_id(),
                    inscricao.getCurso_id(),
                    inscricao.getDataInscricao()
                ))
                .collect(Collectors.toList());
        //return inscricoes;
    }

    public List<InscricaoDto> getInscricoesByCursoId(Long curso_id) {
        List<Inscricao> entities = inscricaoRepository.findByCurso_id(curso_id);
        List<InscricaoDto> inscricoes = entities.stream()
                .map(inscricao -> new InscricaoDto(
                    inscricao.getId(),
                    inscricao.getAluno_id(),
                    inscricao.getCurso_id(),
                    inscricao.getDataInscricao()
                ))
                .collect(Collectors.toList());
        return inscricoes;
    }
}
