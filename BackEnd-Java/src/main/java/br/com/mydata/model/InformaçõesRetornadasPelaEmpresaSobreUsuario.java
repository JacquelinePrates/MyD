package br.com.mydata.model;

import java.util.HashMap;

public class InformaçõesRetornadasPelaEmpresaSobreUsuario {

	private String nomeDaEmpresa;
	private String cnpj;
	private HashMap<String, String> informaçõesDoUsuario;
	
	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}
	public void setNomeDaEmpresa(String nomeDaEmpresa) {
		this.nomeDaEmpresa = nomeDaEmpresa;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public HashMap<String, String> getInformaçõesDoUsuario() {
		return informaçõesDoUsuario;
	}
	public void setInformaçõesDoUsuario(HashMap<String, String> informaçõesDoUsuario) {
		this.informaçõesDoUsuario = informaçõesDoUsuario;
	}
	
	
	
}
