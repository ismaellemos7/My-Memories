package model;

import java.util.List;

public interface ContatoDAO {
	public List<Contato> listarTodosUsuario();
	public Contato verUsuarioPorId(String id);
	public void salvarContato(Contato contato);
	public void deletarContato(Contato contato);
	public void atualizarContato(Contato contato);
}
