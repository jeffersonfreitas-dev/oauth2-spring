package com.appsdeveloperblog.ws.api.Albums;

public class Albums {

	private String codigo;
	private String nome;
	
	public Albums() {}

	public Albums(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
