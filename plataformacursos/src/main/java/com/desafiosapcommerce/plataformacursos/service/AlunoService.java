package com.desafiosapcommerce.plataformacursos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiosapcommerce.plataformacursos.dto.AlunoDto;
import com.desafiosapcommerce.plataformacursos.dto.InscricaoDto;
import com.desafiosapcommerce.plataformacursos.model.Aluno;
import com.desafiosapcommerce.plataformacursos.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InscricaoService inscricaoService;

    public AlunoDto getById(Long id) {
        Aluno entity = alunoRepository.findById(id).orElse(null);

        if (entity == null) {
            return null;
        }

        AlunoDto dto = new AlunoDto(entity);

        List<InscricaoDto> inscricoes = inscricaoService.getInscricaoByAlunoId(id);
        dto.setInscricoes(inscricoes);
        return dto;
    }

    public List<AlunoDto> getAllAlunos() {
        List<Aluno> entities = (List<Aluno>) alunoRepository.findAll();
        List<AlunoDto> dtos = entities.stream()
                .map(aluno -> {
                    AlunoDto dto = new AlunoDto(aluno);
                    List<InscricaoDto> inscricoes = inscricaoService.getInscricaoByAlunoId(aluno.getId());
                    dto.setInscricoes(inscricoes);
                    return dto;
                })
                .collect(Collectors.toList());
        return dtos;
    }

    public AlunoDto getAlunoByEmail(String email) {
        Aluno aluno = alunoRepository.findByEmail(email);
        if (aluno != null) {
            AlunoDto dto = new AlunoDto(aluno);
            List<InscricaoDto> inscricoes = inscricaoService.getInscricaoByAlunoId(aluno.getId());
            dto.setInscricoes(inscricoes);
        }
        return null;        
    }
    
    public AlunoDto insertAlunoDto(Aluno aluno) {
        Aluno entity = alunoRepository.save(aluno);
        AlunoDto dto = new AlunoDto(entity);
        return dto;
    }
    
    public void deleteAlunoDto(Aluno aluno) {
        alunoRepository.delete(aluno);
    }
}
