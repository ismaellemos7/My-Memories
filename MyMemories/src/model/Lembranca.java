package model;

import java.util.Date;

public class Lembranca {
	private String titulo;
	private String texto;
	private Date data;
	private String local;
	
	
	
	public Lembranca() {
		
	}

	public Lembranca(String titulo, String texto, Date data, String local) {
		this.titulo = titulo;
		this.texto = texto;
		this.data = data;
		this.local = local;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	
}
