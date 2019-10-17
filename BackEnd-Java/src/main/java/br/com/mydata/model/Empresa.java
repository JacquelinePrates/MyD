package br.com.mydata.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "empresas")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Empresa extends Usuario{
	private String razaoSocial;
	private String cnpj;
	
	public Empresa() {
		
	}
	
	public Empresa(String razaoSocial, String cnpj) {
		super();
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
