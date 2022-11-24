package com.testedev.teste_desenvolvedor.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_funcionarios")
public class Funcionarios{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeFuncionario;
	private String sobrenomeFuncionario;
	private String email;
	private Long nis;
	
	public Funcionarios() {	
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getSobrenomeFuncionario() {
		return sobrenomeFuncionario;
	}

	public void setSobrenomeFuncionario(String sobrenomeFuncionario) {
		this.sobrenomeFuncionario = sobrenomeFuncionario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNis() {
		return nis;
	}

	public void setNis(Long nis) {
		this.nis = nis;
	}
	
	private static final String EMAIL = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String NOME = 
			"^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]\\w{1,29}$";
	
	private static final String SOBRENOME = 
			"^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]\\w{1,49}$";

	/*private final Pattern pattern = Pattern.compile(EMAIL, Pattern.CASE_INSENSITIVE);
	
	private boolean validarEmail(){
		return pattern.matcher(this.email).matches();
	}*/
	
	private boolean validarEmail(){
		return this.getEmail().matches(EMAIL);
	}
	
	private boolean validarNome() {
		return this.getNomeFuncionario().matches(NOME);
	}
	
	private boolean validarSobrenome() {
		return this.getSobrenomeFuncionario().matches(SOBRENOME);
	}
	
	public boolean isValid() {
		return this.validarEmail() && this.validarNome() && this.validarSobrenome();
	}
	
	public String funcionarioMsg() {
		return "Erro! Verifique se a solicitação atente aos requisitos: "
			 + "\nNome (entre 2 e 30 caracteres)" 
			 + "\nNome (entre 2 e  caracteres)"
			 + "\nE-mail válido";
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id + 
			   "\nNome: " + this.nomeFuncionario +
			   "\nSobrenome: " + this.sobrenomeFuncionario + 
			   "\nE-mail: " + this.email + 
			   "\nNIS: " + this.nis;
	}
}
