package model;

public class Contato {
	private Integer id;
	private String nome;
	private int telefone;
	private Integer contato_usuario;
	private Integer id_usuario;
	private boolean ativo;

	
	
	
	public Contato() {
		this.ativo = false;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContato_usuario() {
		return contato_usuario;
	}

	public void setContato_usuario(Integer contato_usuario) {
		this.contato_usuario = contato_usuario;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
}