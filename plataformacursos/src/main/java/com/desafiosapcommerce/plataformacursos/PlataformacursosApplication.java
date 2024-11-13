package com.desafiosapcommerce.plataformacursos;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desafiosapcommerce.plataformacursos.model.Aluno;
import com.desafiosapcommerce.plataformacursos.model.Curso;
import com.desafiosapcommerce.plataformacursos.repository.AlunoRepository;
import com.desafiosapcommerce.plataformacursos.repository.CursoRepository;

@SpringBootApplication
public class PlataformacursosApplication implements CommandLineRunner {

	// Instanciando os repositórios
	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	public static void main(String[] args) {

		SpringApplication.run(PlataformacursosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Instanciando os alunos
		Aluno aluno1 = new Aluno("João", "joao@gmail.com");
		Aluno aluno2 = new Aluno("Maria", "maria@gmail.com");
		Aluno aluno3 = new Aluno("José", "zeh@gmail.com");
		Aluno aluno4 = new Aluno("Ana", "ana@gmail.com");

		// Adicionando os alunos a lista de alunos
		List<Aluno> alunos = Arrays.asList(aluno1, aluno2, aluno3, aluno4);

		// Instanciando os cursos
		Curso curso1 = new Curso("Java", "Programação Java");
		Curso curso2 = new Curso("Python", "Programação Python");
		Curso curso3 = new Curso("JavaScript", "Programação JavaScript");
		Curso curso4 = new Curso("SQL", "Programação SQL");

		// Adicionando os cursos a lista de cursos
		List<Curso> cursos = Arrays.asList(curso1, curso2, curso3, curso4);

		// Atrelando os cursos aos alunos
		aluno1.addCurso(curso1);
		aluno1.addCurso(curso2);
		aluno2.addCurso(curso3);
		aluno3.addCurso(curso1);
		aluno4.addCurso(curso4);

		// Salvando os cursos
		cursoRepository.saveAll(cursos);
		// Salvando os alunos
		alunoRepository.saveAll(alunos);
	}

}
