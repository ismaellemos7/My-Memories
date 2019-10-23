package model;

public class Tipo_Lembranca {
	private String nome;
	private int id;
	private int codLembranca;
	
	
	public Tipo_Lembranca() {
		super();
	}


	public Tipo_Lembranca(String nome, int id, int codLembranca) {
		super();
		this.nome = nome;
		this.id = id;
		this.codLembranca = codLembranca;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCodLembranca() {
		return codLembranca;
	}


	public void setCodLembranca(int codLembranca) {
		this.codLembranca = codLembranca;
	}
	
}
