package com.testedev.teste_desenvolvedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testedev.teste_desenvolvedor.entities.Funcionarios;

public interface FuncionarioRepository extends JpaRepository<Funcionarios, Long>{
	
}
