package com.desafiosapcommerce.plataformacursos.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.desafiosapcommerce.plataformacursos.dto.AlunoDto;
import com.desafiosapcommerce.plataformacursos.model.Aluno;
import com.desafiosapcommerce.plataformacursos.service.AlunoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunoDto> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    @GetMapping(value = "/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlunoDto getAlunoById(@PathVariable("id") Long id) {
        try {
            return alunoService.getById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado", e);
        }
    }

    @GetMapping(value = "/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public AlunoDto getAlunoByEmail(@PathVariable("email") String email) {
        try {
            return alunoService.getAlunoByEmail(email);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado", e);
        }
    }

    @PostMapping(value = "/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDto insert(@RequestBody Aluno aluno) {
        return alunoService.insertAlunoDto(aluno);
    }
    
    @PutMapping("update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id, @RequestBody Aluno aluno) {
        try {
            AlunoDto alunoDto = alunoService.getById(id);
            if (alunoDto != null) {
                Aluno alunoBase = mapper.map(alunoDto, Aluno.class);
                mapper.map(aluno, alunoBase);
                alunoService.insertAlunoDto(alunoBase);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado", e);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        AlunoDto alunoDto = alunoService.getById(id);
        try {
            if (alunoDto != null) {
                alunoService.deleteAlunoDto(mapper.map(alunoDto, Aluno.class));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }
    }
}
