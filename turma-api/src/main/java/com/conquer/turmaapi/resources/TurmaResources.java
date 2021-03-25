package com.conquer.turmaapi.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conquer.conquerutils.dto.CursoDto;
import com.conquer.conquerutils.dto.TurmaDto;
import com.conquer.turmaapi.services.TurmaService;
import com.google.gson.Gson;

@RestController
public class TurmaResources {

	@Autowired
	private TurmaService turmaService;
	
	@PostMapping(path = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarTurma(@RequestBody TurmaDto turma, HttpServletRequest request){
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(turma));
		
		return ResponseEntity.ok().body(turma);
		
	}
	
	@GetMapping(value = "/consultar", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> consultarTurma(@RequestParam("codigoTurma") String codigoTurma){
		
		TurmaDto turmaDto = this.turmaService.consultarTurma(codigoTurma);
		if(turmaDto != null) {
			return ResponseEntity.ok().body(turmaDto);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao obter Turma.");
		}
	}
}
