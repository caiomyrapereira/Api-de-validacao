package com.example.dadosPessoais.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dadosPessoais.model.DadosPessoais;
import com.example.dadosPessoais.repository.DadosPessoaisRepository;

@Service 
public class DadosPessoaisService {
	
	@Autowired
	private DadosPessoaisRepository repository; 
	
	public DadosPessoais addDados(DadosPessoais dados) {
		// validar cpf
		if(!dados.getCpf().matches("[0-9]{11}") || dados.getCpf().length() != 11) 
			return null;
		
		//validar email e cpf duplicado
		if(repository.findByEmail(dados.getEmail()).isPresent() || repository.findByCpf(dados.getCpf()).isPresent() ) 
			return null;
		
		return repository.save(dados);
	}
	
	public DadosPessoais changeDados(DadosPessoais dados) {
		
		if(!dados.getCpf().matches("[0-9]{11}") || dados.getCpf().length() != 11) 
			return null;
		
		if(repository.findByEmail(dados.getEmail()).isPresent() || repository.findByCpf(dados.getCpf()).isPresent() ) {
			if(!(repository.findByEmail(dados.getEmail()).get().getId() == dados.getId())){
				return null;
			}
			else if(!(repository.findByCpf(dados.getCpf()).get().getId() == dados.getId())) {
				return null;
			}
		}
		return repository.save(dados);
	}
	
}
