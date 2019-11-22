package model;

public class Tipo_Lembranca {
	private String nome;
	private Integer id;
	
	
	public Tipo_Lembranca() {
		super();
	}


	public Tipo_Lembranca(String nome, Integer id, int codLembranca) {
		super();
		this.nome = nome;
		this.id = id;
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


	public void setId(Integer id) {
		this.id = id;
	}
	
}
