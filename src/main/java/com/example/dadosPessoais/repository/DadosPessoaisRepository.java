package com.example.dadosPessoais.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dadosPessoais.model.DadosPessoais;

@Repository
public interface DadosPessoaisRepository extends JpaRepository<DadosPessoais, Long>{
	
	public Optional<DadosPessoais> findByEmail(String email);
	public Optional<DadosPessoais> findByCpf(String cpf);

}
