package com.tt.model;

public class InformacoesUsuario {

	private boolean valido;
	private Usuario usuario;
	private Conta conta;
	private Endereco endereco;
	private Investimentos investimentos;
	private Perfil perfil;
	
	
	public boolean isValido() {
		return valido;
	}
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Investimentos getInvestimentos() {
		return investimentos;
	}
	public void setInvestimentos(Investimentos investimentos) {
		this.investimentos = investimentos;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	
}
