package com.tt.model;

public class Usuario {
	
	private String email;
	private String senha;
	private String nome;
	private String cpf;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String email, String senha, String nome, String cpf, boolean valido) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
}