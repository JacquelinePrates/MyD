package com.tt.model;

import java.util.List;


public class Empresa{
	
	private String razaoSocial;
	private String cnpj;
	private String urlDaLogo;
	private List<Informacao> listaDeInformacoes;
	
	public Empresa() {
		
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
