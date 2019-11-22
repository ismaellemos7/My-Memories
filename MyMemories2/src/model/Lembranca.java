package model;

import java.util.Date;

public class Lembranca {
	private int idLembranca;
	private String titulo;
	private String texto;
	private Date data;
	private String local;
	private int Dono_lembranca;
	private int tipolembranca;
	
	
	
	public Lembranca() {
		
	}

	public Lembranca(String titulo, String texto, Date data, String local) {
		this.titulo = titulo;
		this.texto = texto;
		this.data = data;
		this.local = local;
	}
	public int getIdLembranca() {
		return idLembranca;
	}

	public void setIdLembranca(int idLembranca) {
		this.idLembranca = idLembranca;
	}

	public int getDono_lembranca() {
		return Dono_lembranca;
	}

	public void setDono_lembranca(int dono_lembranca) {
		Dono_lembranca = dono_lembranca;
	}

	public int getTipolembranca() {
		return tipolembranca;
	}

	public void setTipolembranca(int tipolembranca) {
		this.tipolembranca = tipolembranca;
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