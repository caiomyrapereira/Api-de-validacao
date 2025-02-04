package com.example.dadosPessoais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dadosPessoais.model.DadosPessoais;
import com.example.dadosPessoais.repository.DadosPessoaisRepository;
import com.example.dadosPessoais.service.DadosPessoaisService;

@RestController
@RequestMapping("/dados_pessoais")
@CrossOrigin("*")
public class DadosPessoaisController {
	
	@Autowired
	private DadosPessoaisRepository repository; 
	
	@Autowired
	private DadosPessoaisService dadosPessoaisService;
	
	@GetMapping
	public ResponseEntity<List<DadosPessoais>> getAll(){
		return ResponseEntity.ok(repository.findAll()); 	
	}
	
	@PostMapping
	public ResponseEntity<DadosPessoais> post (@RequestBody  DadosPessoais dados){
		return ResponseEntity.status(HttpStatus.CREATED).body(dadosPessoaisService.addDados(dados));
	}
	
	@PutMapping
	public ResponseEntity<DadosPessoais> put(@RequestBody DadosPessoais dados) {
		return ResponseEntity.status(HttpStatus.OK).body( dadosPessoaisService.changeDados(dados) );
	}
	
	@DeleteMapping("/{id}") 
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
