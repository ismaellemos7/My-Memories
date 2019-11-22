package model;

public class ContatoLembranca {
	private int idLembranca;
	private int idContato;
	
	
	
	public ContatoLembranca() {
		super();
	}
	
	
	public ContatoLembranca(int idLembranca, int idContato) {
		super();
		this.idLembranca = idLembranca;
		this.idContato = idContato;
	}


	public int getIdLembranca() {
		return idLembranca;
	}
	
	
	public void setIdLembranca(int idLembranca) {
		this.idLembranca = idLembranca;
	}
	
	
	public int getIdContato() {
		return idContato;
	}
	
	
	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}
	
	
}
