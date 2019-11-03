package br.com.mydata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "empresas")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Empresa{
	
	@Id @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String razaoSocial;
	private String cnpj;
	private String urlDeConexao;
	
	public Empresa() {
		
	}
	
	public Empresa(String razaoSocial, String cnpj) {
		super();
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUrlDeConexao() {
		return urlDeConexao;
	}

	public void setUrlDeConexao(String urlDeConexao) {
		this.urlDeConexao = urlDeConexao;
	}	
}
