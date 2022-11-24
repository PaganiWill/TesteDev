package com.testedev.teste_desenvolvedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testedev.teste_desenvolvedor.entities.Funcionarios;
import com.testedev.teste_desenvolvedor.services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {
	
	@Autowired
	public FuncionarioService service;

	@GetMapping
	public List<Funcionarios> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/buscar/{id}")
	public Funcionarios findById(@PathVariable Long id){
		return service.findById(id);
	}
	
	@PostMapping
	public String insert(@RequestBody Funcionarios funcionario){
		if(funcionario.isValid()) {
			service.insert(funcionario);
			return "Usuário cadastrado com sucesso: \n" + funcionario.toString();
		}
		
		return funcionario.funcionarioMsg();
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public String update(@PathVariable Long id, @RequestBody Funcionarios funcionario) {
		if(funcionario.isValid()) {			
			if(service.atualizar(id, funcionario) != null) {
				return "Atualizado com sucesso: \n" + funcionario.toString();
			}

			return "Id não localizado!";
		}
		
		return funcionario.funcionarioMsg(); 
	}
	
	@DeleteMapping(value = "/remover/{id}")
	public String deleteById(@PathVariable Long id) {
		
		return service.deleteById(id);
		
	}
}
