package br.com.mydata.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "empresas")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Empresa{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String razaoSocial;
	private String cnpj;
	
	@JsonIgnore
	private String urlDeConexao;
	
	@JsonInclude @Transient
	private String urlDaLogo;
	@JsonInclude @Transient
	private List<Informacao> listaDeInformacoes;
	
	public Empresa() {
		
	}

	public Empresa(String razaoSocial, String cnpj, String urlDeConexao) {
		super();
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.urlDeConexao = urlDeConexao;
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

	public String getUrlDaLogo() {
		return urlDaLogo;
	}

	public void setUrlDaLogo(String urlDaLogo) {
		this.urlDaLogo = urlDaLogo;
	}

	public List<Informacao> getListaDeInformacoes() {
		return listaDeInformacoes;
	}

	public void setListaDeInformacoes(List<Informacao> listaDeInformacoes) {
		this.listaDeInformacoes = listaDeInformacoes;
	}
}
