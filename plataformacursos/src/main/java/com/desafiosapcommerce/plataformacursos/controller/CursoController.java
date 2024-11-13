package com.desafiosapcommerce.plataformacursos.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.desafiosapcommerce.plataformacursos.dto.CursoDto;
import com.desafiosapcommerce.plataformacursos.model.Curso;
import com.desafiosapcommerce.plataformacursos.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CursoDto> getAllCursoDtos() {
        return cursoService.getCursos();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CursoDto getCursoById(@PathVariable("id") Long id) {
        try {
            return cursoService.getById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado", e);
        }
    }

    @GetMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public CursoDto getCursoByEmail(@PathVariable("name") String name) {
        try {
            return cursoService.getCursoByNome(name);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado", e);
        }
    }

    @PostMapping(value = "/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public CursoDto insert(@RequestBody Curso curso) {
        return cursoService.insertCursoDto(curso);
    }
    
    @PutMapping("update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id, @RequestBody Curso curso) {
        try {
            CursoDto cursoDto = cursoService.getById(id);
            if (cursoDto != null) {
                Curso cursoBase = mapper.map(cursoDto, Curso.class);
                mapper.map(curso, cursoBase);
                cursoService.insertCursoDto(cursoBase);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado", e);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        CursoDto cursoDto = cursoService.getById(id);
        try {
            if (cursoDto != null) {
                cursoService.deleteCursoDto(mapper.map(cursoDto, Curso.class));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }
    }
}
