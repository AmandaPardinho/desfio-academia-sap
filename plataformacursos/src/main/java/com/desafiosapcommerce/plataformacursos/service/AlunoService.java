package com.desafiosapcommerce.plataformacursos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiosapcommerce.plataformacursos.dto.AlunoDto;
import com.desafiosapcommerce.plataformacursos.model.Aluno;
import com.desafiosapcommerce.plataformacursos.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoDto getById(Long id) {
        Aluno entity = alunoRepository.findById(id).get();
        AlunoDto dto = new AlunoDto(entity);
        return dto;
    }

    public List<AlunoDto> getAlunos() {
        List<Aluno> entities = (List<Aluno>) alunoRepository.findAll();
        List<AlunoDto> dtos = entities.stream().map(AlunoDto::new).collect(Collectors.toList());
        return dtos;
    }

    public AlunoDto getAlunoByEmail(String email) {
        Aluno aluno = alunoRepository.findByEmail(email);
        if (aluno != null) {
            return new AlunoDto(aluno);
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
