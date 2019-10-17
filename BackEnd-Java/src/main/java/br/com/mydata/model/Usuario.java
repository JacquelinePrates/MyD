package br.com.mydata.model;

public class Usuario<T> {
	private long id;
	private String email;
	private String senha;
	private T tipo;
	
	public Usuario() {
		
	}
	
	public Usuario(long id, String email, String senha, T tipo) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public T getTipo() {
		return tipo;
	}

	public void setTipo(T tipo) {
		this.tipo = tipo;
	}
	
}
