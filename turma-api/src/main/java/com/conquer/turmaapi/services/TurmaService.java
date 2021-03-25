package com.conquer.turmaapi.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.conquer.conquerutils.dto.CursoDto;
import com.conquer.conquerutils.dto.TurmaDto;

@Service
public class TurmaService {

	public boolean registrarTurma(TurmaDto turma) {
//		Aqui ficara a classe de negócio que validará os dados informados, 
//		criará uma entidade e subsequentemente efetuará a inclusão através da persistência
		return true;
	}
	
	public TurmaDto consultarTurma(String codigoTurma) {
//		Aqui ficará a chamada à classe de negócio e persistência necessária para buscar a turma na base de dados

//		Apenas para fins de exemplo ------------------------------------------
		TurmaDto turmaDto = new TurmaDto();
		turmaDto.setCodigoTurma(codigoTurma);
		turmaDto.setDataInicio(new Date(2021, 3, 17));
		turmaDto.setVagasDisponiveis(Long.valueOf(100));
		
		CursoDto curso = new CursoDto();
		curso.setCargaHoraria(Long.valueOf(135));
		curso.setCodigoCurso("1");
		curso.setDescricaoCurso("Curso de pacote office");
		curso.setNomeCurso("Curso Office");
		curso.setPrecoCurso(1599.99);
		
		turmaDto.setCurso(curso);
//		Apenas para fins de exemplo ------------------------------------------
		
		return  turmaDto;
	}

		
}
