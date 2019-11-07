package br.com.mydata.model;

import java.util.List;

public class InformacoesPessoaisBasicas {
	
	
	private Integer id;
	
	private String nome;
	private String cpf;
	private String email;
	public InformacoesPessoaisBasicas() {
	}
	

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
