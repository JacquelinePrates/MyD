package br.com.mydata.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "titulares")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Titular extends Usuario{
	private String nome;
	private String cpf;
	
	public Titular() {
		
	}
	
	public Titular(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
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
