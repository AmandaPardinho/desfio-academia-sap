package com.desafiosapcommerce.plataformacursos;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.desafiosapcommerce.plataformacursos.model.Aluno;
import com.desafiosapcommerce.plataformacursos.model.Curso;
import com.desafiosapcommerce.plataformacursos.model.Inscricao;
import com.desafiosapcommerce.plataformacursos.repository.AlunoRepository;
import com.desafiosapcommerce.plataformacursos.repository.CursoRepository;
import com.desafiosapcommerce.plataformacursos.repository.InscricaoRepository;

@SpringBootApplication
public class PlataformacursosApplication implements CommandLineRunner {

	// Instanciando os repositórios
	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
    private InscricaoRepository inscricaoRepository;

	@Bean 
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		return mapper;
	}

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

		// Instanciando os cursos
		Curso curso1 = new Curso("Java", "Programação Java");
		Curso curso2 = new Curso("Python", "Programação Python");
		Curso curso3 = new Curso("JavaScript", "Programação JavaScript");
		Curso curso4 = new Curso("SQL", "Programação SQL");

		// Salvando os cursos e os alunos
		cursoRepository.saveAll(Arrays.asList(curso1, curso2, curso3, curso4));
        alunoRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4));

		// Atrelando os cursos aos alunos
		Inscricao inscricao1 = new Inscricao(aluno1, curso1);
        Inscricao inscricao2 = new Inscricao(aluno1, curso2);
        Inscricao inscricao3 = new Inscricao(aluno2, curso1);
		Inscricao inscricao4 = new Inscricao(aluno3, curso4);
		Inscricao inscricao5 = new Inscricao(aluno4, curso3);
		Inscricao inscricao6 = new Inscricao(aluno4, curso4);

        inscricaoRepository.saveAll(Arrays.asList(inscricao1, inscricao2, inscricao3, inscricao4, inscricao5, inscricao6));

	}

}
