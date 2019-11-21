package com.projeto.myd.com.projeto.myd.model;

import java.util.List;

public class Empresa{

	private Long id;
	private String razaoSocial;
	private String cnpj;
	private String urlDaLogo;
	private List<Informacao> listaDeInformacoes;
	
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
