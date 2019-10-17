package model;

public class Usuario {
	private String nome;
	private String email;
	private int senha;
	private int telefone;
	
	public Usuario(String nome, String email, int senha, int telefone){
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public int getSenha(){
		return senha;
	}
	
	public int setSenha(int senha){
		this.senha = senha;
	}
	
	public int getTelefone(){
		return telefone;
	}
	
	public int setTelefone(int telefone){
		this.telefone = telefone;
	}
	
}
